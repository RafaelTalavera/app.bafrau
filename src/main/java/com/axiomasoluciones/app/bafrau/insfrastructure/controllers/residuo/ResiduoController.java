package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.ResiduoDTO;

import com.axiomasoluciones.app.bafrau.domain.services.residuo.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residuos")
@CrossOrigin(origins = "*")
public class ResiduoController {

    private final ResiduoService residuoService;

    @Autowired
    public ResiduoController(ResiduoService residuoService) {
        this.residuoService = residuoService;
    }

    @GetMapping
    public List<ResiduoDTO> obtenerTodos() {
        return residuoService.findAll();
    }

    @GetMapping("/{id}")
    public ResiduoDTO obtenerPorId(@PathVariable Long id) {
        return residuoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResiduoDTO crear(@RequestBody ResiduoDTO dto) {
        return residuoService.create(dto);
    }

    @PutMapping("/{id}")
    public ResiduoDTO actualizar(@PathVariable Long id, @RequestBody ResiduoDTO dto) {
        return residuoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        residuoService.delete(id);
    }
}