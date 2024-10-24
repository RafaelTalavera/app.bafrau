package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.seccion;

import com.axiomasoluciones.app.bafrau.application.dto.seccion.SeccionDTO;
import com.axiomasoluciones.app.bafrau.domain.services.seccion.ISeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secciones")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeccionController {

    @Autowired
    private ISeccionService seccionService;

    @GetMapping
    public ResponseEntity<List<SeccionDTO>> getAllSecciones() {
        List<SeccionDTO> secciones = seccionService.findAll();
        return ResponseEntity.ok(secciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeccionDTO> getSeccionById(@PathVariable Long id) {
        Optional<SeccionDTO> seccion = seccionService.findById(id);
        return seccion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SeccionDTO> createSeccion(@RequestBody SeccionDTO seccionDTO) {
        SeccionDTO createdSeccion = seccionService.create(seccionDTO);
        return ResponseEntity.ok(createdSeccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeccionDTO> updateSeccion(@PathVariable Long id, @RequestBody SeccionDTO seccionDTO) {
        SeccionDTO updatedSeccion = seccionService.update(id, seccionDTO);
        return ResponseEntity.ok(updatedSeccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeccion(@PathVariable Long id) {
        seccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
