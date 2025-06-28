package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.InsumoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.InsumoService;
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
@RequestMapping("/api/insumos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public ResponseEntity<List<InsumoDTO>> getAllInsumos() {
        List<InsumoDTO> insumos = insumoService.findAll();
        return new ResponseEntity<>(insumos, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/proceso/{procesoId}")
    public ResponseEntity<List<InsumoDTO>> getInsumosByProcesoId(@PathVariable Long procesoId) {
        List<InsumoDTO> insumos = insumoService.getInsumosByProcesoId(procesoId);
        return ResponseEntity.ok(insumos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<InsumoDTO> getInsumoById(@PathVariable Long id) {
        InsumoDTO insumo = insumoService.findById(id);
        return new ResponseEntity<>(insumo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InsumoDTO> createInsumo(@RequestPart("insumo") InsumoDTO insumoDTO,
                                                  @RequestPart("fichaTecnica") MultipartFile fichaTecnica) throws IOException {
        Map<String, String> uploadResult = cloudinaryService.upload(fichaTecnica);
        String fichaTecnicaUrl = uploadResult.get("url");
        insumoDTO.setFichaTecnica(fichaTecnicaUrl);
        InsumoDTO createdInsumo = insumoService.save(insumoDTO);
        return new ResponseEntity<>(createdInsumo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsumoDTO> updateInsumo(@PathVariable Long id, @RequestBody InsumoDTO insumoDTO) {
        InsumoDTO updatedInsumo = insumoService.update(id, insumoDTO);
        return new ResponseEntity<>(updatedInsumo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsumo(@PathVariable Long id) {
        insumoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<InsumoDTO>> getInsumosByOrganizacionId(@PathVariable Long organizacionId) {
        List<InsumoDTO> insumos = insumoService.getInsumoByOrganizacionId(organizacionId);
        return ResponseEntity.ok(insumos);
    }
}
