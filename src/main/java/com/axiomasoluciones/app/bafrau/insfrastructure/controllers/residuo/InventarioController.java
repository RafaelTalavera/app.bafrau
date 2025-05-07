package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.InventarioDTO;
import com.axiomasoluciones.app.bafrau.application.dto.residuo.ItemInventarioDTO;
import com.axiomasoluciones.app.bafrau.domain.services.residuo.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
@CrossOrigin(origins = "*")
public class InventarioController {

    private final InventarioService inventarioService;

    @Autowired
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<InventarioDTO> obtenerTodos() {
        return inventarioService.findAll();
    }

    @GetMapping("/{id}")
    public InventarioDTO obtenerPorId(@PathVariable Long id) {
        return inventarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioDTO crear(@RequestBody InventarioDTO dto) {
        return inventarioService.create(dto);
    }

    @PutMapping("/{id}")
    public InventarioDTO actualizar(@PathVariable Long id, @RequestBody InventarioDTO dto) {
        return inventarioService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        inventarioService.delete(id);
    }

    @GetMapping("/{id}/items")
    public List<ItemInventarioDTO> obtenerItemsPorInventario(@PathVariable Long id) {
        return inventarioService.findItemsByInventario(id);
    }
}
