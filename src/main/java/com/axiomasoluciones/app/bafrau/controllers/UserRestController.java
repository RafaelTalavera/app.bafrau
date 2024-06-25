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
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {
    @Autowired
    private IUserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("permitAll")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
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
                null, // No devuelvas la contraseña codificada
                data.getRole()
        );

        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

  /*  @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateOrganizador(
            @PathVariable Long id,
            @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO updatedUser = service.editeUser(id, userRequestDTO);
        return ResponseEntity.ok(updatedUser);
    }

   */

    @GetMapping
    @PreAuthorize("permitAll")
    public ResponseEntity<List<UserResponseDTO>> getAllOrganizadores(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            System.out.println("Token recibido: " + token);

            String role = service.extractUserEmailFromToken(token);
            System.out.println("Rol extraído del token: " + role);

            if (!role.equals("ADMINISTRATOR")) {
                System.out.println("El usuario no tiene permisos de administrador.");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            List<UserResponseDTO> organizadores = service.findAll();
            return ResponseEntity.ok(organizadores);
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
