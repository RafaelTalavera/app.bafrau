package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ServicioDisponibleDTO;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.IServicioDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicioDisponibleController {

    @Autowired
    private IServicioDisponibleService servicioDisponibleService;

    @GetMapping
    public ResponseEntity<List<ServicioDisponibleDTO>> getAllServiciosDisponibles() {
        List<ServicioDisponibleDTO> servicios = servicioDisponibleService.findAll();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<ServicioDisponibleDTO>> getServiciosDisponiblesByOrganizacionId(@PathVariable Long organizacionId) {
        List<ServicioDisponibleDTO> servicios = servicioDisponibleService.getServicioDisponibleByOrganizacionId(organizacionId);
        return ResponseEntity.ok(servicios);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ServicioDisponibleDTO> getServicioDisponibleById(@PathVariable Long id) {
        Optional<ServicioDisponibleDTO> servicio = servicioDisponibleService.findById(id);
        return servicio.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ServicioDisponibleDTO> createServicioDisponible(@RequestBody ServicioDisponibleDTO servicioDisponibleDTO) {
        ServicioDisponibleDTO createdServicio = servicioDisponibleService.create(servicioDisponibleDTO);
        return new ResponseEntity<>(createdServicio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioDisponibleDTO> updateServicioDisponible(@PathVariable Long id, @RequestBody ServicioDisponibleDTO servicioDisponibleDTO) {
        try {
            ServicioDisponibleDTO updatedServicio = servicioDisponibleService.update(id, servicioDisponibleDTO);
            return new ResponseEntity<>(updatedServicio, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicioDisponible(@PathVariable Long id) {
        try {
            servicioDisponibleService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}