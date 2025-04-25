package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcedimientoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.ProcedimientoService;
import com.axiomasoluciones.app.bafrau.insfrastructure.claudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/procedimientos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProcedimientoController {

    @Autowired
    private ProcedimientoService procedimientoService;

    @Autowired
    private CloudinaryService cloudinaryService;

    // Crear un nuevo Procedimiento
    @PostMapping
    public ResponseEntity<ProcedimientoDTO> createProcedimiento(
            @RequestPart("procedimiento") ProcedimientoDTO procedimientoDTO,
            @RequestPart("adjunto") MultipartFile adjuntoFile) throws IOException {

        Map<String, String> uploadResult = cloudinaryService.upload(adjuntoFile);
        String adjuntoUrl = uploadResult.get("url");
        procedimientoDTO.setAdjunto(adjuntoUrl);
        ProcedimientoDTO createdProcedimiento = procedimientoService.createProcedimiento(procedimientoDTO);
        return new ResponseEntity<>(createdProcedimiento, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcedimientoDTO> getProcedimientoById(@PathVariable Long id) {
        ProcedimientoDTO procedimientoDTO = procedimientoService.getProcedimientoById(id);
        return ResponseEntity.ok(procedimientoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProcedimientoDTO>> getAllProcedimientos() {
        List<ProcedimientoDTO> procedimientos = procedimientoService.getAllProcedimientos();
        return ResponseEntity.ok(procedimientos);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<ProcedimientoDTO>> getProcedimientosByOrganizacionId(@PathVariable Long organizacionId) {
        List<ProcedimientoDTO> procedimientos = procedimientoService.getProcedimientosByOrganizacionId(organizacionId);
        return ResponseEntity.ok(procedimientos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcedimientoDTO> updateProcedimiento(
            @PathVariable Long id,
            @RequestPart("procedimiento") ProcedimientoDTO procedimientoDTO,
            @RequestPart(value = "adjunto", required = false) MultipartFile adjuntoFile) throws IOException {

        if (adjuntoFile != null) {
            Map<String, String> uploadResult = cloudinaryService.upload(adjuntoFile);
            String adjuntoUrl = uploadResult.get("url");
            procedimientoDTO.setAdjunto(adjuntoUrl);
        }
        ProcedimientoDTO updatedProcedimiento = procedimientoService.updateProcedimiento(id, procedimientoDTO);
        return ResponseEntity.ok(updatedProcedimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedimiento(@PathVariable Long id) {
        procedimientoService.deleteProcedimientoById(id);
        return ResponseEntity.noContent().build();
    }
}