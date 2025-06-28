package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.NominaEmpleadosDTO;

import com.axiomasoluciones.app.bafrau.domain.services.organizacion.NominaEmpleadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nomina-empleados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NominaEmpleadosController {

    private final NominaEmpleadosService nominaEmpleadosService;

    public NominaEmpleadosController(NominaEmpleadosService nominaEmpleadosService) {
        this.nominaEmpleadosService = nominaEmpleadosService;
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<NominaEmpleadosDTO>> getAllNominaEmpleados() {
        List<NominaEmpleadosDTO> nominaEmpleadosList = nominaEmpleadosService.getAllNominaEmpleados();
        return ResponseEntity.ok(nominaEmpleadosList);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<NominaEmpleadosDTO>> getNominaEmpleadosByOrganizacionId(@PathVariable Long organizacionId) {
        List<NominaEmpleadosDTO> nominaEmpleadosList = nominaEmpleadosService.getNominaEmpleadosByOrganizacionId(organizacionId);
        return ResponseEntity.ok(nominaEmpleadosList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<NominaEmpleadosDTO> getNominaEmpleadoById(@PathVariable Long id) {
        NominaEmpleadosDTO nominaEmpleadosDTO = nominaEmpleadosService.getNominaEmpleadoById(id);
        return ResponseEntity.ok(nominaEmpleadosDTO);
    }

    @PostMapping
    public ResponseEntity<NominaEmpleadosDTO> createNominaEmpleado(@RequestBody NominaEmpleadosDTO nominaEmpleadosDTO) {
        NominaEmpleadosDTO createdNominaEmpleado = nominaEmpleadosService.createNominaEmpleado(nominaEmpleadosDTO);
        return ResponseEntity.ok(createdNominaEmpleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NominaEmpleadosDTO> updateNominaEmpleado(@PathVariable Long id, @RequestBody NominaEmpleadosDTO nominaEmpleadosDTO) {
        NominaEmpleadosDTO updatedNominaEmpleado = nominaEmpleadosService.updateNominaEmpleado(id, nominaEmpleadosDTO);
        return ResponseEntity.ok(updatedNominaEmpleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNominaEmpleado(@PathVariable Long id) {
        nominaEmpleadosService.deleteNominaEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}