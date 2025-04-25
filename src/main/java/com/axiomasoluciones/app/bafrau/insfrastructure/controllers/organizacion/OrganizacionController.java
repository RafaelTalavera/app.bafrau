package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.serviceImplement.user.JwtServiceImplements;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.OrganizacionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizaciones")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrganizacionController {

    @Autowired
    private OrganizacionService organizacionService;

    @Autowired
    private JwtServiceImplements jwtService;

    @GetMapping
    public ResponseEntity<List<OrganizacionDTO>> getAllOrganizaciones(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");

            if (token == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            String role = jwtService.extractRoleFromToken(token);
            List<OrganizacionDTO> informes;

            if ("ADMINISTRATOR".equals(role) || "USER".equals(role)) {
                informes = organizacionService.findAll();
            } else if ("CUSTOMER".equals(role)) {
                String organizacion = organizacionService.extractOrganizacionFromToken(token);
                informes = organizacionService.findByOrganizacion(organizacion);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            return new ResponseEntity<>(informes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizacionDTO> getOrganizacionById(@PathVariable Long id) {
        Optional<OrganizacionDTO> organizacion = organizacionService.findById(id);
        return organizacion.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OrganizacionDTO> createOrganizacion(@RequestBody OrganizacionDTO organizacionDTO, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            OrganizacionDTO createdOrganizacion = organizacionService.create(organizacionDTO, token);
            return new ResponseEntity<>(createdOrganizacion, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrganizacionDTO> updateOrganizacion(@PathVariable Long id, @RequestBody OrganizacionDTO organizacionDTO) {
        System.out.println("Actualizando informe con ID: " + id);
        System.out.println("Datos recibidos: " + organizacionDTO);

        try {
            OrganizacionDTO updatedInforme = organizacionService.update(id, organizacionDTO);
            if (updatedInforme != null) {
                return new ResponseEntity<>(updatedInforme, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizacion(@PathVariable Long id) {
        try {
            organizacionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/razonesSociales")
    public List<OrganizacionDTO> obtenerTodasLasRazonesSociales(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token no proporcionado");
        }

        return organizacionService.obtenerRazonesSociales();
    }

}
