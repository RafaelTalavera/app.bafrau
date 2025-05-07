package com.axiomasoluciones.app.bafrau.application.serviceImplement.user;


import com.axiomasoluciones.app.bafrau.application.dto.user.UserDTO;

import com.axiomasoluciones.app.bafrau.application.mappers.user.UserMapper;
import com.axiomasoluciones.app.bafrau.domain.repository.user.UserRepository;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import com.axiomasoluciones.app.bafrau.domain.services.user.IUserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private UserMapper userMapper;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplement.class);

    @Override
    public List<UserDTO> findAll() {
        Iterable<User> users = userDAO.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::toUserDTO) // Uso correcto del mapper
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userDAO.findById(id).map(userMapper::toUserDTO); // Uso correcto del mapper
    }

    @Override
    public UserDTO createUser(UserDTO userRequestDTO) {
        String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        User newUser = userMapper.toUser(userRequestDTO);
        newUser.setPassword(encodedPassword);
        User savedUser = userDAO.save(newUser);

        return userMapper.toUserDTO(savedUser);
    }

    @Override
    public void deletedById(Long id) {
        logger.info("Attempting to delete user with ID: {}", id);

        if (userDAO.existsById(id)) {
            userDAO.deleteById(id);
            logger.info("User with ID: {} deleted successfully", id);
        } else {
            logger.warn("User with ID: {} not found", id);
        }
    }

    @Override
    public UserDTO editedUser(Long id, UserDTO dto) {
        User user = userDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));

        // Campos simples
        user.setUsername(dto.getUsername());
        user.setNombre(dto.getNombre());
        user.setLastname(dto.getLastname());
        user.setDni(dto.getDni());
        user.setOrganizacion(dto.getOrganizacion());
        user.setTitulo(dto.getTitulo());
        user.setMatriculaProvincia(dto.getMatriculaProvincia());
        user.setMatriculaColegioNeuquen(dto.getMatriculaColegioNeuquen());
        user.setMatriculaMunicipal(dto.getMatriculaMunicipal());
        user.setAddress(dto.getAddress());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());


        // Contraseña sólo si se envía
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        User saved = userDAO.save(user);
        return userMapper.toUserDTO(saved);
    }


    @Override
    public boolean existsByUsername(String username) {
        return userDAO.existsByUsername(username);
    }

    @Override
    public String extractUserEmailFromToken(String token) {
        try {
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            String role = claims.get("role", String.class);
            System.out.println("Role extraído del token: " + role);
            return role;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer el correo electrónico del token", e);
        }
    }

    @Override
    public Long extractUserIdFromToken(String token) {
        try {
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            Long userId = claims.get("userId", Long.class);
            System.out.println("User ID extraído del token: " + userId);
            return userId;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer el user ID del token", e);
        }
    }
}
