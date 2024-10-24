package com.axiomasoluciones.app.bafrau.application.serviceImplement.user;

import com.axiomasoluciones.app.bafrau.application.dto.user.AuthenticationRequestDTO;
import com.axiomasoluciones.app.bafrau.application.dto.user.AuthenticationResponseDTO;
import com.axiomasoluciones.app.bafrau.domain.repository.user.UserRepository;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImplements {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private JwtServiceImplements jwtService;

    public AuthenticationResponseDTO login(AuthenticationRequestDTO authenticationRequest) {
        // Imprimir los datos recibidos del frontend
        System.out.println("Datos recibidos del frontend: " + authenticationRequest);

        // Crear el token de autenticación
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (authenticationRequest.username(), authenticationRequest.password());

        // Imprimir el token de autenticación
        System.out.println("Token de autenticación: " + authenticationToken);

        // Intentar autenticar al usuario
        authenticationManager.authenticate(authenticationToken);

        // Obtener al usuario desde la base de datos
        User user = userDao.findByUsername(authenticationRequest.username()).get();

        // Imprimir los datos del usuario
        System.out.println("Datos del usuario autenticado: " + user);

        // Generar el token JWT
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        // Imprimir el token JWT generado
        System.out.println("Token JWT generado: " + jwt);

        // Crear y retornar la respuesta DTO
        return new AuthenticationResponseDTO(jwt);
    }

    private Map<String, Object> generateExtraClaims(User user){
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("mail", user.getNombre());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("permissions", user.getAuthorities());
        return extraClaims;
    }



}