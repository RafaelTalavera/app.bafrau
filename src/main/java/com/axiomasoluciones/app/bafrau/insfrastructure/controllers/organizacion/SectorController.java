package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.SectorDTO;

import com.axiomasoluciones.app.bafrau.domain.services.organizacion.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping
    public ResponseEntity<List<SectorDTO>> getAllSectors() {
        List<SectorDTO> sectors = sectorService.findAll();
        return new ResponseEntity<>(sectors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDTO> getSectorById(@PathVariable Long id) {
        SectorDTO sector = sectorService.findById(id);
        return new ResponseEntity<>(sector, HttpStatus.OK);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<SectorDTO>> getSectorByOrganizacionId(@PathVariable Long organizacionId) {
        List<SectorDTO> sectores = sectorService.getSectorByOrganizacionId(organizacionId);
        return ResponseEntity.ok(sectores);
    }


    @PostMapping
    public ResponseEntity<SectorDTO> createSector(@RequestBody SectorDTO sectorDTO) {
        SectorDTO createdSector = sectorService.save(sectorDTO);
        return new ResponseEntity<>(createdSector, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDTO> updateSector(@PathVariable Long id, @RequestBody SectorDTO sectorDTO) {
        SectorDTO updatedSector = sectorService.update(id, sectorDTO);
        return new ResponseEntity<>(updatedSector, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        sectorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}