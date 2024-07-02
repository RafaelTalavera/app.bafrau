package com.axiomasoluciones.app.bafrau.controllers;

import com.axiomasoluciones.app.bafrau.dto.request.AccionRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.AccionResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.Accion;
import com.axiomasoluciones.app.bafrau.services.IAccionService;
import com.axiomasoluciones.app.bafrau.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acciones")
@CrossOrigin(origins = "http://localhost:4200")
public class AccionRestController {

    @Autowired
    private IAccionService accionService;

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<AccionResponseDTO> createAccione(
            @RequestBody AccionRequestDTO accionRequestDTO,
            HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            String role = userService.extractUserEmailFromToken(token);
            if (!role.equals("ADMINISTRATOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            AccionResponseDTO accionResponseDTO = accionService.createAccion(accionRequestDTO);
            return new ResponseEntity<>(accionResponseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el stack trace en caso de excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AccionResponseDTO>> getAllAcciones(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            String role = userService.extractUserEmailFromToken(token);

            if (!role.equals("ADMINISTRATOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            List<AccionResponseDTO> acciones = accionService.findAll();
            return ResponseEntity.ok(acciones);


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccionResponseDTO> updatedAccion(
            @PathVariable Long id,
            @RequestBody AccionRequestDTO accionRequestDTO,
            HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            String role = userService.extractUserEmailFromToken(token);
            if (!role.equals("ADMINISTRATOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            AccionResponseDTO updatedAccion = accionService.editedAccion(id, accionRequestDTO);
            return ResponseEntity.ok(updatedAccion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id,
                                           HttpServletRequest request) {

        try {
            String token = request.getHeader("Authorization");
            String role = userService.extractUserEmailFromToken(token);
            if (!role.equals("ADMINISTRATOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        accionService.deleteById(id);
        return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{clasificacion}")
    public List<AccionResponseDTO> getAccionesByClasificacion(@PathVariable String clasificacion) {
        return accionService.findByClasificacion(clasificacion);
    }
}
