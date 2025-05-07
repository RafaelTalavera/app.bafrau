package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.domain.services.legal.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controles")
@CrossOrigin(origins = "*")
public class ControlController {

    private final ControlService controlService;

    @Autowired
    public ControlController(ControlService controlService) {
        this.controlService = controlService;
    }

    @PostMapping
    public ResponseEntity<ControlDTO> crear(@RequestBody ControlDTO controlDTO) {
        return ResponseEntity.status(201).body(controlService.crearControl(controlDTO));
    }

    @GetMapping
    public ResponseEntity<List<ControlDTO>> obtenerTodos() {
        return ResponseEntity.ok(controlService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(controlService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        controlService.eliminarControl(id);
        return ResponseEntity.noContent().build();
    }
}
