package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.ItemUIPUpdateDTO;
import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;
import com.axiomasoluciones.app.bafrau.domain.services.matriz.IMatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matrices")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MatrizController {

    @Autowired
    private IMatrizService matrizService;

    @GetMapping
    public ResponseEntity<List<MatrizDTO>> getAll() {
        List<MatrizDTO> list = matrizService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatrizDTO> getMatrizById(@PathVariable Long id) {
        Optional<MatrizDTO> matriz = matrizService.findById(id);
        return matriz.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MatrizDTO> createMatriz(@RequestBody MatrizDTO matrizDTO) {
        MatrizDTO createdMatriz = matrizService.create(matrizDTO);
        return ResponseEntity.ok(createdMatriz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatrizDTO> updateMatriz(@PathVariable Long id, @RequestBody MatrizDTO matrizDTO) {
        MatrizDTO updatedMatriz = matrizService.update(id, matrizDTO);
        return ResponseEntity.ok(updatedMatriz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatriz(@PathVariable Long id) {
        matrizService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/uip")
    public ResponseEntity<MatrizDTO> updateUIP(
            @PathVariable Long id,
            @RequestBody List<ItemUIPUpdateDTO> updates) {
        MatrizDTO updated = matrizService.updateUIP(id, updates);
        return ResponseEntity.ok(updated);
    }

}
