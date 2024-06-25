package com.axiomasoluciones.app.bafrau.controllers;

import com.axiomasoluciones.app.bafrau.dto.request.InformeRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.InformeResponseDTO;
import com.axiomasoluciones.app.bafrau.services.IInformeService;
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

    @PostMapping
    public ResponseEntity<InformeResponseDTO> createInforme(@RequestBody InformeRequestDTO informeRequestDTO) {
        InformeResponseDTO informeResponseDTO = informeService.createInforme(informeRequestDTO);
        return new ResponseEntity<>(informeResponseDTO, HttpStatus.CREATED);
    }
}