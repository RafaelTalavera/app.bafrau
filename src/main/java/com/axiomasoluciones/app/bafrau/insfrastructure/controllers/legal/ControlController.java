package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.application.dto.legal.ItemControlDTO;
import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;
import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionSimpleDTO;
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

    @GetMapping("/test-notifications")
    public ResponseEntity<Void> test() {
            controlService.checkAndSendNotifications();
            return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControlDTO> editar(@PathVariable Long id,
                                             @RequestBody ControlDTO controlDTO) {
        ControlDTO actualizado = controlService.editarControl(id, controlDTO);
        return ResponseEntity.ok(actualizado);
    }

    @PatchMapping("/items/{itemId}/estado")
    public ResponseEntity<ItemControlDTO> cambiarEstadoItem(@PathVariable Long itemId) {
        ItemControlDTO dto = controlService.cambiarEstadoItem(itemId);
        return ResponseEntity.ok(dto);
    }
    // GET /api/controles/organizaciones
    @GetMapping("/organizaciones")
    public ResponseEntity<List<OrganizacionSimpleDTO>> organizacionesConItems() {
        var listaSimple = controlService.obtenerOrganizacionesConItemsControl();
        return ResponseEntity.ok(listaSimple);
    }


    // GET /api/controles/organizaciones/{orgId}/items
    @GetMapping("/organizaciones/{orgId}/items")
    public ResponseEntity<List<ItemControlDTO>> itemsPorOrganizacion(
            @PathVariable("orgId") Long organizacionId) {
        List<ItemControlDTO> items = controlService.obtenerItemsPorOrganizacion(organizacionId);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemControlDTO>> obtenerTodosItems() {
        List<ItemControlDTO> items = controlService.obtenerTodosItems();
        return ResponseEntity.ok(items);
    }
}
