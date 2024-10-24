package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InsumoDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcesoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.ProcesoService;
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

    @GetMapping("/informe/{informeId}")
    public ResponseEntity<List<ProcesoDTO>> getProcesosByInformeId(@PathVariable Long informeId) {
        List<ProcesoDTO> procesos = procesoService.getProcesoByInformeId(informeId);
        return ResponseEntity.ok(procesos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcesoDTO> getProcesoById(@PathVariable Long id) {
        ProcesoDTO proceso = procesoService.findById(id);
        return new ResponseEntity<>(proceso, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createProceso(@RequestBody ProcesoDTO procesoDTO) {
        if (procesoDTO.getInformeId() == null) {
            return new ResponseEntity<>("El ID del informe es obligatorio.", HttpStatus.BAD_REQUEST);
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
