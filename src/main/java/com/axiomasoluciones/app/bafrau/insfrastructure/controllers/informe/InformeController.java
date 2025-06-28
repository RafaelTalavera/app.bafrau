package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.InformeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informes")
@CrossOrigin(origins = "*")
public class InformeController {

    private final InformeService service;

    @Autowired
    public InformeController(InformeService service) {
        this.service = service;
    }

    @GetMapping
    public List<InformeDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformeDTO> getById(@PathVariable Long id) {
        InformeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<InformeDTO> create(@Valid @RequestBody InformeDTO dto) {
        InformeDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformeDTO> update(@PathVariable Long id,
                                             @Valid @RequestBody InformeDTO dto) {
        InformeDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
