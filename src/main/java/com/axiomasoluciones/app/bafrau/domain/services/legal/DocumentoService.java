package com.axiomasoluciones.app.bafrau.domain.services.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.DocumentoDTO;

import java.util.List;


public interface DocumentoService {

    DocumentoDTO crearDocumento(DocumentoDTO documentoDTO);

    DocumentoDTO obtenerDocumentoPorId(Long id);

    List<DocumentoDTO> obtenerTodosLosDocumentos();

    DocumentoDTO actualizarDocumento(Long id, DocumentoDTO documentoDTO);

    void eliminarDocumento(Long id);
}