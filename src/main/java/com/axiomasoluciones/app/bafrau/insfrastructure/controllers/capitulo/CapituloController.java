package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.capitulo;

import com.axiomasoluciones.app.bafrau.application.dto.capitulo.CapituloDTO;
import com.axiomasoluciones.app.bafrau.domain.services.capitulo.ICapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capitulos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CapituloController {

    @Autowired
    private ICapituloService capituloService;

    @GetMapping
    public ResponseEntity<List<CapituloDTO>> getAllCapitulos() {
        List<CapituloDTO> capitulos = capituloService.findAll();
        return ResponseEntity.ok(capitulos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapituloDTO> getCapituloById(@PathVariable Long id) {
        Optional<CapituloDTO> capitulo = capituloService.findById(id);
        return capitulo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CapituloDTO> createCapitulo(@RequestBody CapituloDTO capituloDTO) {
        CapituloDTO createdCapitulo = capituloService.create(capituloDTO);
        return ResponseEntity.ok(createdCapitulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CapituloDTO> updateCapitulo(@PathVariable Long id, @RequestBody CapituloDTO capituloDTO) {
        CapituloDTO updatedCapitulo = capituloService.update(id, capituloDTO);
        return ResponseEntity.ok(updatedCapitulo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCapitulo(@PathVariable Long id) {
        capituloService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
