package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CorreoDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.TelefonoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.ICorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/correos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorreoController {

    @Autowired
    private ICorreoService correoService;

    @GetMapping
    public ResponseEntity<List<CorreoDTO>> getAllCorreos() {
        List<CorreoDTO> correos = correoService.findAll();
        return new ResponseEntity<>(correos, HttpStatus.OK);
    }

    @GetMapping("/informe/{informeId}")
    public ResponseEntity<List<CorreoDTO>> getTelefonosByInformeId(@PathVariable Long informeId) {
        List<CorreoDTO> correos = correoService.getCorreosByInformeId(informeId);
        return ResponseEntity.ok(correos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorreoDTO> getCorreoById(@PathVariable Long id) {
        Optional<CorreoDTO> correo = correoService.findById(id);
        return correo.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CorreoDTO> createCorreo(@RequestBody CorreoDTO correoDTO) {
        CorreoDTO createdCorreo = correoService.create(correoDTO);
        return new ResponseEntity<>(createdCorreo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CorreoDTO> updateCorreo(@PathVariable Long id, @RequestBody CorreoDTO correoDTO) {
        try {
            CorreoDTO updatedCorreo = correoService.update(id, correoDTO);
            return new ResponseEntity<>(updatedCorreo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorreo(@PathVariable Long id) {
        try {
            correoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}