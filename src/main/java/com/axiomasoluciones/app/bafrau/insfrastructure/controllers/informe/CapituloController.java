package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CapituloDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenCapituloDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenSeccionDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.CapituloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capitulos")
@CrossOrigin(origins = "*")
public class CapituloController {

    private final CapituloService service;

    @Autowired
    public CapituloController(CapituloService service) {
        this.service = service;
    }

    @GetMapping
    public List<CapituloDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapituloDTO> getById(@PathVariable Long id) {
        CapituloDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CapituloDTO> create(@Valid @RequestBody CapituloDTO dto) {
        CapituloDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CapituloDTO> update(@PathVariable Long id,
                                              @Valid @RequestBody CapituloDTO dto) {
        CapituloDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/ordenes")
    public ResponseEntity<Void> updateOrdenes(
            @RequestBody List<OrdenCapituloDTO> ordenes
    ) {
        service.updateOrdenes(ordenes);
        return ResponseEntity.noContent().build();
    }
}
