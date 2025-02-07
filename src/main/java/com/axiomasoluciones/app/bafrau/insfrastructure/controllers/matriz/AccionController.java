package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.AccionDTO;
import com.axiomasoluciones.app.bafrau.domain.services.matriz.IAccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acciones")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccionController {

    private final IAccionService accionService;

    public AccionController(IAccionService accionService) {
        this.accionService = accionService;
    }

    @GetMapping
    public ResponseEntity<List<AccionDTO>> getAllAcciones() {
        return ResponseEntity.ok(accionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccionDTO> getAccionById(@PathVariable Long id) {
        Optional<AccionDTO> accionDTO = accionService.findById(id);
        return accionDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AccionDTO> createAccion(@RequestBody AccionDTO accionDTO) {
        return ResponseEntity.ok(accionService.create(accionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccionDTO> updateAccion(@PathVariable Long id, @RequestBody AccionDTO accionDTO) {
        return ResponseEntity.ok(accionService.update(id, accionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccion(@PathVariable Long id) {
        accionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Nuevo endpoint para buscar por clasificación
    @GetMapping("/search/clasificacion")
    public ResponseEntity<List<AccionDTO>> searchByClasificacion(@RequestParam String query) {
        return ResponseEntity.ok(accionService.findByClasificacion(query));
    }

    // Nuevo endpoint para buscar por tipo
    @GetMapping("/search/tipo")
    public ResponseEntity<List<AccionDTO>> searchByTipo(@RequestParam String query) {
        return ResponseEntity.ok(accionService.findByTipo(query));
    }

}
