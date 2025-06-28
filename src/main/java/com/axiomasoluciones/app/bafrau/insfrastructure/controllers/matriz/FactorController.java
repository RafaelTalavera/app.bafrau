package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.FactorDTO;

import com.axiomasoluciones.app.bafrau.domain.services.matriz.IFactorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FactorController {

    private final IFactorService factorService;

    public FactorController(IFactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping
    public ResponseEntity<List<FactorDTO>> getAllFactores() {
        return ResponseEntity.ok(factorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactorDTO> getFactorById(@PathVariable Long id) {
        return ResponseEntity.ok(factorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FactorDTO> createFactor(@RequestBody FactorDTO factorDTO) {
        return ResponseEntity.ok(factorService.save(factorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactorDTO> updateFactor(@PathVariable Long id, @RequestBody FactorDTO factorDTO) {
        return ResponseEntity.ok(factorService.update(id, factorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactor(@PathVariable Long id) {
        factorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
