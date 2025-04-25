package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.TelefonoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.ITelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/telefonos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TelefonoController {

    @Autowired
    private ITelefonoService telefonoService;

    @GetMapping
    public ResponseEntity<List<TelefonoDTO>> getAllTelefonos() {
        List<TelefonoDTO> telefonos = telefonoService.findAll();
        return new ResponseEntity<>(telefonos, HttpStatus.OK);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<TelefonoDTO>> getTelefonosByOrganizacionId(@PathVariable Long organizacionId) {
        List<TelefonoDTO> telefonos = telefonoService.getTelefonosByOrganizacionId(organizacionId);
        return ResponseEntity.ok(telefonos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TelefonoDTO> getTelefonoById(@PathVariable Long id) {
        Optional<TelefonoDTO> telefono = telefonoService.findById(id);
        return telefono.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TelefonoDTO> createTelefono(@RequestBody TelefonoDTO telefonoDTO) {
        TelefonoDTO createdTelefono = telefonoService.create(telefonoDTO);
        return new ResponseEntity<>(createdTelefono, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefonoDTO> updateTelefono(@PathVariable Long id, @RequestBody TelefonoDTO telefonoDTO) {
        try {
            TelefonoDTO updatedTelefono = telefonoService.update(id, telefonoDTO);
            return new ResponseEntity<>(updatedTelefono, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefono(@PathVariable Long id) {
        try {
            telefonoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
