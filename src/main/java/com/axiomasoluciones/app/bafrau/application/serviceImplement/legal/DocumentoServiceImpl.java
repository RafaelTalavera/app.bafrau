package com.axiomasoluciones.app.bafrau.application.serviceImplement.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.DocumentoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.legal.DocumentoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Documento;
import com.axiomasoluciones.app.bafrau.domain.repository.legal.DocumentoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.legal.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoRepository repository;
    private final DocumentoMapper mapper;

    @Autowired
    public DocumentoServiceImpl(DocumentoRepository repository, DocumentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DocumentoDTO crearDocumento(DocumentoDTO documentoDTO) {
        Documento documento = mapper.toEntity(documentoDTO);
        return mapper.toDTO(repository.save(documento));
    }

    @Override
    public DocumentoDTO obtenerDocumentoPorId(Long id) {
        Documento documento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Documento no encontrado"));
        return mapper.toDTO(documento);
    }

    @Override
    public List<DocumentoDTO> obtenerTodosLosDocumentos() {
        Iterable<Documento> documentos = repository.findAll();
        return StreamSupport.stream(documentos.spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public DocumentoDTO actualizarDocumento(Long id, DocumentoDTO documentoDTO) {
        Documento existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Documento no encontrado"));

        documentoDTO.setId(id);
        Documento actualizado = mapper.toEntity(documentoDTO);
        return mapper.toDTO(repository.save(actualizado));
    }

    @Override
    public void eliminarDocumento(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Documento no encontrado");
        }
        repository.deleteById(id);
    }
}