package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.AdjuntoInformeDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.AdjuntoInformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/adjunto-informe")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdjuntoInformeController {

    @Autowired
    private AdjuntoInformeService adjuntoInformeService;

    @GetMapping
    public List<AdjuntoInformeDTO> findAll() {
        return adjuntoInformeService.findAll();
    }

    @GetMapping("/{id}")
    public AdjuntoInformeDTO findById(@PathVariable Long id) {
        return adjuntoInformeService.findById(id);
    }

    @PostMapping
    public AdjuntoInformeDTO save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("informeId") Long informeId) {

        return adjuntoInformeService.save(file, descripcion, informeId);
    }

    @PutMapping("/{id}")
    public AdjuntoInformeDTO update(
            @PathVariable Long id,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "descripcion", required = false) String descripcion) {

        return adjuntoInformeService.update(id, file, descripcion);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        adjuntoInformeService.deleteById(id);
    }

    @GetMapping("/informe/{informeId}")
    public List<AdjuntoInformeDTO> getAdjuntosByInformeId(@PathVariable Long informeId) {
        return adjuntoInformeService.getAdjuntosByInformeId(informeId);
    }
}