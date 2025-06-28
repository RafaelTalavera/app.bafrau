package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.EncabezadoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.EncabezadoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encabezados")
@CrossOrigin(origins = "*")
public class EncabezadoController {

    private final EncabezadoService service;

    public EncabezadoController(EncabezadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EncabezadoDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EncabezadoDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EncabezadoDTO create(@RequestBody EncabezadoDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public EncabezadoDTO update(@PathVariable Long id, @RequestBody EncabezadoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/informe/{informeId}")
    public List<EncabezadoDTO> getByInformeId(@PathVariable Long informeId) {
        return service.findByInformeId(informeId);
    }
}