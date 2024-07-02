package com.axiomasoluciones.app.bafrau.controllers;

import com.axiomasoluciones.app.bafrau.dto.request.FactorRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.FactorResponseDTO;
import com.axiomasoluciones.app.bafrau.services.IFactorService;
import com.axiomasoluciones.app.bafrau.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factores")
@CrossOrigin(origins = "http://localhost:4200")
public class FactorRestController {

    @Autowired
    private IFactorService factorService;

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<FactorResponseDTO> createFactor(
            @RequestBody FactorRequestDTO factorRequestDTO,
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

            FactorResponseDTO factorResponseDTO = factorService.createFactor(factorRequestDTO);
            return new ResponseEntity<>(factorResponseDTO, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el stack trace en caso de excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FactorResponseDTO>> getAllFactores(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            String role = userService.extractUserEmailFromToken(token);

            if (!role.equals("ADMINISTRATOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            List<FactorResponseDTO> factores = factorService.findAll();
            return ResponseEntity.ok(factores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactorResponseDTO> updatedFactor(
            @PathVariable Long id,
            @RequestBody FactorRequestDTO factorRequestDTO,
            HttpServletRequest request
    ) {
        try {
            String token = request.getHeader("Authorization");
            String role = userService.extractUserEmailFromToken(token);

            if (!role.equals("ADMINISTRATOR")) {
                System.out.println("Role is not ADMINISTRATOR, returning FORBIDDEN status");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            FactorResponseDTO updatedFactor = factorService.editedUser(id, factorRequestDTO);
            return ResponseEntity.ok(updatedFactor);
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
            factorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{clasificacion}")
    public List<FactorResponseDTO> getFactoresByClasificacion(@PathVariable String clasificacion){
        return factorService.findByClasificacion(clasificacion);
    }

}
