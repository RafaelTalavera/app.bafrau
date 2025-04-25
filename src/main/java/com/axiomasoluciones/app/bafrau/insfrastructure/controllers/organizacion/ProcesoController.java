package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcesoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.ProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procesos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProcesoController {

    @Autowired
    private ProcesoService procesoService;

    @GetMapping
    public ResponseEntity<List<ProcesoDTO>> getAllProcesos() {
        List<ProcesoDTO> procesos = procesoService.findAll();
        return new ResponseEntity<>(procesos, HttpStatus.OK);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<ProcesoDTO>> getProcesosByOrganizacionId(@PathVariable Long organizacionId) {
        List<ProcesoDTO> procesos = procesoService.getProcesoByOrganizacionId(organizacionId);
        return ResponseEntity.ok(procesos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcesoDTO> getProcesoById(@PathVariable Long id) {
        ProcesoDTO proceso = procesoService.findById(id);
        return new ResponseEntity<>(proceso, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createProceso(@RequestBody ProcesoDTO procesoDTO) {
        if (procesoDTO.getOrganizacionId() == null) {
            return new ResponseEntity<>("El ID de la organizacion es obligatorio.", HttpStatus.BAD_REQUEST);
        }

        ProcesoDTO createdProceso = procesoService.save(procesoDTO);
        return new ResponseEntity<>(createdProceso, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProcesoDTO> updateProceso(@PathVariable Long id, @RequestBody ProcesoDTO procesoDTO) {
        ProcesoDTO updatedProceso = procesoService.update(id, procesoDTO);
        return new ResponseEntity<>(updatedProceso, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProceso(@PathVariable Long id) {
        procesoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
