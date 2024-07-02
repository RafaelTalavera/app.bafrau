package com.axiomasoluciones.app.bafrau.controllers;

import com.axiomasoluciones.app.bafrau.dto.request.UserRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.UserResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.Role;
import com.axiomasoluciones.app.bafrau.models.entities.User;
import com.axiomasoluciones.app.bafrau.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {
    @Autowired
    private IUserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("permitAll")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO data){
        if (service.existsByUsername(data.getUsername())) {
            return new ResponseEntity<>("Ya existe un usuario con este correo electrónico", HttpStatus.CONFLICT);
        }
        service.createUser(data);
        UserResponseDTO userResponseDTO = new UserResponseDTO(
                null, // O el ID si es posible obtenerlo
                data.getUsername(),
                data.getNombre(),
                data.getApellido(),
                null,
                data.getDni(),
                data.getRole()
        );

        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

   @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateOrganizador(
            @PathVariable Long id,
            @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = service.editedUser(id, userRequestDTO);
        return ResponseEntity.ok(updatedUser);
    }


    @GetMapping
    @PreAuthorize("permitAll")
    public ResponseEntity<List<UserResponseDTO>> getAllUsuarios(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");

            if (token == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            String role = service.extractUserEmailFromToken(token);

            if (!role.equals("ADMINISTRATOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            List<UserResponseDTO> usuarios = service.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el stack trace en caso de excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deletedById(id);
        return ResponseEntity.noContent().build();
    }
}

