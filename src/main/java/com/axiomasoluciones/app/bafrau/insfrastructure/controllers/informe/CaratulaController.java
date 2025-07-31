package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CaratulaDTO;
import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.informe.CaratulaService;
import com.axiomasoluciones.app.bafrau.domain.services.utility.AdjuntoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/caratulas")
@CrossOrigin(origins = "*")
public class CaratulaController {

    private final CaratulaService caratulaService;
    private final AdjuntoService adjuntoService;

    @Autowired
    public CaratulaController(CaratulaService caratulaService,
                              AdjuntoService adjuntoService) {
        this.caratulaService = caratulaService;
        this.adjuntoService = adjuntoService;
    }

    /** Listar todas las carátulas */
    @GetMapping
    public List<CaratulaDTO> getAll() {
        return caratulaService.findAll();
    }

    /** Obtener carátula por su ID */
    @GetMapping("/{id}")
    public ResponseEntity<CaratulaDTO> getById(@PathVariable Long id) {
        CaratulaDTO dto = caratulaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    /** Listar carátulas de un informe concreto */
    @GetMapping("/informe/{informeId}")
    public List<CaratulaDTO> getByInforme(@PathVariable Long informeId) {
        return caratulaService.findByInformeId(informeId);
    }

    /** Crear nueva carátula (incluyendo adjuntos en el payload) */
    @PostMapping
    public ResponseEntity<CaratulaDTO> create(@Valid @RequestBody CaratulaDTO dto) {
        CaratulaDTO created = caratulaService.create(dto.getInformeId(), dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /** Actualizar carátula existente (gestión de adjuntos con adjuntosIds) */
    @PutMapping("/{id}")
    public ResponseEntity<CaratulaDTO> update(@PathVariable Long id,
                                              @Valid @RequestBody CaratulaDTO dto) {
        CaratulaDTO updated = caratulaService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    /** Eliminar carátula por su ID */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        caratulaService.delete(id);
    }

    // ——————————————————————————————————————————
    // N O V E D A D E S: gestión de adjuntos
    // ——————————————————————————————————————————

    /** Subir un adjunto (imagen) a la carátula */
    @PostMapping(value = "/{id}/adjuntos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdjuntoDTO> uploadAdjunto(
            @PathVariable Long id,
            @RequestPart("file") MultipartFile file,
            @RequestPart(value = "descripcion", required = false) String descripcion
    ) {
        AdjuntoDTO dto = adjuntoService.saveToCaratula(file, descripcion, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    /** Eliminar un adjunto de la carátula */
    @DeleteMapping("/{id}/adjuntos/{adjuntoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdjunto(
            @PathVariable("id") Long caratulaId,
            @PathVariable("adjuntoId") Long adjuntoId
    ) {
        // Nota: no es necesario usar caratulaId aquí, pero podrías validar si quieres
        adjuntoService.deleteById(adjuntoId);
    }
}
