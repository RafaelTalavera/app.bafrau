package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.application.serviceImplement.user.JwtServiceImplements;
import com.axiomasoluciones.app.bafrau.domain.services.informe.IInformeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/informes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InformeController {

    @Autowired
    private IInformeService informeService;

    @Autowired
    private JwtServiceImplements jwtService; // Inyecta el servicio JWT

    // Obtener todos los informes
    @GetMapping
    public ResponseEntity<List<InformeDTO>> getAllInformes(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");

            if (token == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            String role = jwtService.extractRoleFromToken(token);
            List<InformeDTO> informes;

            if ("ADMINISTRATOR".equals(role)) {
                // Si es administrador, devuelve todos los informes
                informes = informeService.findAll();
            } else if ("CUSTOMER".equals(role)) {
                // Si es cliente, filtra por organización
                String organizacion = informeService.extractOrganizacionFromToken(token);
                informes = informeService.findByOrganizacion(organizacion);
            } else {
                // Si el rol no es reconocido, devuelve Forbidden
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            return new ResponseEntity<>(informes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración, puedes eliminar esto en producción
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un informe por ID
    @GetMapping("/{id}")
    public ResponseEntity<InformeDTO> getInformeById(@PathVariable Long id) {
        Optional<InformeDTO> informe = informeService.findById(id);
        return informe.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo informe
    @PostMapping
    public ResponseEntity<InformeDTO> createInforme(@RequestBody InformeDTO informeDTO, HttpServletRequest request) {
        try {
            // Extraer el token del encabezado "Authorization"
            String token = request.getHeader("Authorization");

            if (token == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);  // No hay token en la solicitud
            }

            // Crear el informe utilizando el token para extraer el userId
            InformeDTO createdInforme = informeService.create(informeDTO, token);
            return new ResponseEntity<>(createdInforme, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<InformeDTO> updateInforme(@PathVariable Long id, @RequestBody InformeDTO informeDTO) {
        // Log para verificar los datos de entrada
        System.out.println("Actualizando informe con ID: " + id);
        System.out.println("Datos recibidos: " + informeDTO);

        try {
            InformeDTO updatedInforme = informeService.update(id, informeDTO);
            if (updatedInforme != null) {
                return new ResponseEntity<>(updatedInforme, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // Eliminar un informe por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInforme(@PathVariable Long id) {
        try {
            informeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/razonesSociales")
    public List<InformeDTO> obtenerTodasLasRazonesSociales(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token no proporcionado");
        }

        return informeService.obtenerRazonesSociales();
    }

}
