package com.axiomasoluciones.app.bafrau.controllers;

import com.axiomasoluciones.app.bafrau.dto.request.InformeRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.InformeResponseDTO;
import com.axiomasoluciones.app.bafrau.services.IInformeService;
import com.axiomasoluciones.app.bafrau.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/informes")
@CrossOrigin(origins = "http://localhost:4200")
public class InformeRestController {

    @Autowired
    private IInformeService informeService;

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<InformeResponseDTO> createInforme(@RequestBody InformeRequestDTO informeRequestDTO,
                                                            HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization").replace("Bearer ", "");
            Long userId = userService.extractUserIdFromToken(token);
            return ResponseEntity.ok(informeService.createInforme(informeRequestDTO, userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}