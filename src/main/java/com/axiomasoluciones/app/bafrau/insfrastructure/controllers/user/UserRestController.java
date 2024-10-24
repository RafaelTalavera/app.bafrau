package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.user;


import com.axiomasoluciones.app.bafrau.application.dto.user.UserDTO;
import com.axiomasoluciones.app.bafrau.domain.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRestController {

    @Autowired
    private IUserService service;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO data) {
        // Validar si existe un usuario con el mismo username
        if (service.existsByUsername(data.getUsername())) {
            return new ResponseEntity<>("Ya existe un usuario con este correo electrónico", HttpStatus.CONFLICT);
        }
        // Crear el usuario y obtener el UserDTO creado
        UserDTO createdUser = service.createUser(data);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO userRequestDTO) {
        // Editar el usuario y obtener el UserDTO actualizado
        UserDTO updatedUser = service.editedUser(id, userRequestDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<UserDTO>> getAllUsuarios(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");

            if (token == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            String role = service.extractUserEmailFromToken(token);

            if (!role.equals("ADMINISTRATOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            // Obtener todos los usuarios como UserDTO
            List<UserDTO> usuarios = service.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deletedById(id);
        return ResponseEntity.noContent().build();
    }
}
