package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcedimientoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.ProcedimientoService;
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

        // Subir el archivo a Cloudinary
        Map<String, String> uploadResult = cloudinaryService.upload(adjuntoFile);

        // Obtener la URL del archivo subido
        String adjuntoUrl = uploadResult.get("url");
        procedimientoDTO.setAdjunto(adjuntoUrl);

        // Crear el Procedimiento
        ProcedimientoDTO createdProcedimiento = procedimientoService.createProcedimiento(procedimientoDTO);

        return new ResponseEntity<>(createdProcedimiento, HttpStatus.CREATED);
    }

    // Obtener Procedimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProcedimientoDTO> getProcedimientoById(@PathVariable Long id) {
        ProcedimientoDTO procedimientoDTO = procedimientoService.getProcedimientoById(id);
        return ResponseEntity.ok(procedimientoDTO);
    }

    // Obtener todos los Procedimientos
    @GetMapping
    public ResponseEntity<List<ProcedimientoDTO>> getAllProcedimientos() {
        List<ProcedimientoDTO> procedimientos = procedimientoService.getAllProcedimientos();
        return ResponseEntity.ok(procedimientos);
    }

    // Obtener Procedimientos por Informe ID
    @GetMapping("/informe/{informeId}")
    public ResponseEntity<List<ProcedimientoDTO>> getProcedimientosByInformeId(@PathVariable Long informeId) {
        List<ProcedimientoDTO> procedimientos = procedimientoService.getProcedimientosByInformeId(informeId);
        return ResponseEntity.ok(procedimientos);
    }

    // Actualizar un Procedimiento
    @PutMapping("/{id}")
    public ResponseEntity<ProcedimientoDTO> updateProcedimiento(
            @PathVariable Long id,
            @RequestPart("procedimiento") ProcedimientoDTO procedimientoDTO,
            @RequestPart(value = "adjunto", required = false) MultipartFile adjuntoFile) throws IOException {

        if (adjuntoFile != null) {
            // Subir el nuevo archivo a Cloudinary
            Map<String, String> uploadResult = cloudinaryService.upload(adjuntoFile);

            // Obtener la URL del archivo subido
            String adjuntoUrl = uploadResult.get("url");
            procedimientoDTO.setAdjunto(adjuntoUrl);
        }

        // Actualizar el Procedimiento
        ProcedimientoDTO updatedProcedimiento = procedimientoService.updateProcedimiento(id, procedimientoDTO);

        return ResponseEntity.ok(updatedProcedimiento);
    }

    // Eliminar un Procedimiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedimiento(@PathVariable Long id) {
        procedimientoService.deleteProcedimientoById(id);
        return ResponseEntity.noContent().build();
    }
}