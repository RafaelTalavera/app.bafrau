package com.axiomasoluciones.app.bafrau.controllers;

import com.axiomasoluciones.app.bafrau.dto.request.MatrizRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.MatrizResponseDTO;
import com.axiomasoluciones.app.bafrau.services.IMatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/matrices")
@CrossOrigin(origins = "http://localhost:4200")
public class MatrizRestController {

    @Autowired
    private IMatrizService matrizService;

    @PostMapping
    public ResponseEntity<MatrizResponseDTO> createMatriz(@RequestBody MatrizRequestDTO matrizRequestDTO){
        MatrizResponseDTO matrizResponseDTO = matrizService.createMatriz(matrizRequestDTO);
        return new ResponseEntity<>(matrizResponseDTO, HttpStatus.CREATED);
    }

}
