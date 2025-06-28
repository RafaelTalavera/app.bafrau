package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.StyleTemplateDTO;
import com.axiomasoluciones.app.bafrau.domain.services.utility.StyleTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/styles")
@CrossOrigin(origins = "*") // Ajustá según el frontend
public class StyleTemplateController {

    private final StyleTemplateService service;

    public StyleTemplateController(StyleTemplateService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StyleTemplateDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StyleTemplateDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findeById(id));
    }

    @PostMapping
    public ResponseEntity<StyleTemplateDTO> create(@RequestBody StyleTemplateDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StyleTemplateDTO> update(@PathVariable Long id, @RequestBody StyleTemplateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}