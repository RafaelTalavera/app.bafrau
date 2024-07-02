package com.axiomasoluciones.app.bafrau.services.implement;

import com.axiomasoluciones.app.bafrau.dto.request.UserRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.UserResponseDTO;
import com.axiomasoluciones.app.bafrau.models.dao.UserRepository;
import com.axiomasoluciones.app.bafrau.models.entities.User;
import com.axiomasoluciones.app.bafrau.services.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImplement implements IUserService {

    @Autowired
    private UserRepository userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    @Override
    public List<UserResponseDTO> findAll() {
        Iterable<User> users = userDAO.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserResponseDTO> findById(Long id) {
        return userDAO.findById(id).map(this::convertToResponseDTO);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        User newUser = new User(
                userRequestDTO.getUsername(),
                userRequestDTO.getNombre(),
                userRequestDTO.getApellido(),
                encodedPassword,  // Almacenar la contraseña codificada
                userRequestDTO.getDni(),
                userRequestDTO.getRole()
        );
        User savedUser = userDAO.save(newUser);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getNombre(),
                savedUser.getApellido(),
                null,
                savedUser.getDni(),
                savedUser.getRole()
        );
    }

    @Override
    public void deletedById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public UserResponseDTO editedUser(Long id, UserRequestDTO editedUserRequestDTO) {
        Optional<User> optionalUser = userDAO.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(editedUserRequestDTO.getUsername());
            user.setNombre(editedUserRequestDTO.getNombre());
            user.setApellido(editedUserRequestDTO.getApellido());
            user.setPassword(editedUserRequestDTO.getPassword());
            user.setDni(editedUserRequestDTO.getDni());
            user.setRole(editedUserRequestDTO.getRole());
            User updatedUser = userDAO.save(user);
            return convertToResponseDTO(updatedUser);
        }
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userDAO.existsByUsername(username);
    }

    @Override
    public String extractUserEmailFromToken(String token) {
        try {
            // Remover la palabra "Bearer " del inicio del token
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            String role = claims.get("role", String.class);
            System.out.println("Role extraído del token: " + role); // Imprimir el rol extraído del token
            return role;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer el correo electrónico del token", e);
        }
    }

    @Override
    public Long extractUserIdFromToken(String token) {
        try {
            // Remover la palabra "Bearer " del inicio del token
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            Long userId = claims.get("userId", Long.class);
            System.out.println("User ID extraído del token: " + userId); // Imprimir el userId extraído del token
            return userId;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer el user ID del token", e);
        }
    }


    // Métodos de conversión entre User y DTOs
    private UserResponseDTO convertToResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setApellido(user.getApellido());
        dto.setPassword(user.getPassword());
        dto.setDni(user.getDni());
        dto.setNombre(user.getNombre());

        return dto;
    }

    private User convertToEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setNombre(dto.getNombre());
        user.setApellido(dto.getApellido());
        user.setDni(dto.getDni());
        user.setRole(dto.getRole());
        return user;
    }
}