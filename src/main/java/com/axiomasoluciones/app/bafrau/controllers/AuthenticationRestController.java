package com.axiomasoluciones.app.bafrau.controllers;

import com.axiomasoluciones.app.bafrau.dto.request.AuthenticationRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.AuthenticationResponseDTO;
import com.axiomasoluciones.app.bafrau.services.implement.AuthenticationServiceImplements;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {


    @Autowired
    private AuthenticationServiceImplements authenticationService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("permitAll")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> login(
            @RequestBody @Valid AuthenticationRequestDTO authRequest){
        System.out.println("Método login() fue invocado con la solicitud: " + authRequest);
        AuthenticationResponseDTO jwtDto = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PreAuthorize("permitAll")
    @GetMapping("/public-access")
    public String publicAccessEndpoint(){
        return "este endpoint es público";
    }



}