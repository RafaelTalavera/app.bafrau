package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.utility.AdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/adjunto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdjuntoController {

    @Autowired
    private AdjuntoService adjuntoService;

    @GetMapping
    public List<AdjuntoDTO> findAll() {
        return adjuntoService.findAll();
    }

    @GetMapping("/{id}")
    public AdjuntoDTO findById(@PathVariable Long id) {
        return adjuntoService.findById(id);
    }

    @PostMapping
    public AdjuntoDTO save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("informeId") Long organizacionId) {

        return adjuntoService.save(file, descripcion, organizacionId);
    }

    @PutMapping("/{id}")
    public AdjuntoDTO update(
            @PathVariable Long id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "descripcion", required = false) String descripcion) {

        return adjuntoService.update(id, file, descripcion);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        adjuntoService.deleteById(id);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public List<AdjuntoDTO> getAdjuntosByOrganizacionId(@PathVariable Long organizacionId) {
        return adjuntoService.getAdjuntosByOrganizacionId(organizacionId);
    }
}