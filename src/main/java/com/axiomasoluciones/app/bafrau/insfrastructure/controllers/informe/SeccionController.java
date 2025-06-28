package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenSeccionDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.SeccionDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.SeccionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secciones")
@CrossOrigin(origins = "*")
public class SeccionController {

    private final SeccionService service;

    @Autowired
    public SeccionController(SeccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SeccionDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeccionDTO> getById(@PathVariable Long id) {
        SeccionDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<SeccionDTO> create(@Valid @RequestBody SeccionDTO dto) {
        SeccionDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeccionDTO> update(@PathVariable Long id,
                                             @Valid @RequestBody SeccionDTO dto) {
        SeccionDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/ordenes")
    public ResponseEntity<Void> updateOrdenes(
            @RequestBody List<OrdenSeccionDTO> ordenes
    ) {
        service.updateOrdenes(ordenes);
        return ResponseEntity.noContent().build();
    }
}
