package com.axiomasoluciones.app.bafrau.insfrastructure.controllers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.DocumentoDTO;
import com.axiomasoluciones.app.bafrau.domain.services.legal.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@CrossOrigin(origins = "*")
public class DocumentoController {

    private final DocumentoService documentoService;

    @Autowired
    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping
    public ResponseEntity<DocumentoDTO> crear(@RequestBody DocumentoDTO dto) {
        return ResponseEntity.ok(documentoService.crearDocumento(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(documentoService.obtenerDocumentoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DocumentoDTO>> obtenerTodos() {
        return ResponseEntity.ok(documentoService.obtenerTodosLosDocumentos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoDTO> actualizar(@PathVariable Long id, @RequestBody DocumentoDTO dto) {
        return ResponseEntity.ok(documentoService.actualizarDocumento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        documentoService.eliminarDocumento(id);
        return ResponseEntity.noContent().build();
    }
}
