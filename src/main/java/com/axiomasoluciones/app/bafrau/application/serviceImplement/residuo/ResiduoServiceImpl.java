package com.axiomasoluciones.app.bafrau.application.serviceImplement.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.ResiduoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.residuo.ResiduoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.residuo.Residuo;
import com.axiomasoluciones.app.bafrau.domain.repository.residuo.ResiduoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.residuo.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ResiduoServiceImpl implements ResiduoService {

    private final ResiduoRepository repository;
    private final ResiduoMapper mapper;

    @Autowired
    public ResiduoServiceImpl(ResiduoRepository repository, ResiduoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ResiduoDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResiduoDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Residuo no encontrado con id: " + id)
                );
    }

    @Override
    public ResiduoDTO create(ResiduoDTO dto) {
        Residuo entidad = mapper.toEntity(dto);
        Residuo guardado = repository.save(entidad);
        return mapper.toDTO(guardado);
    }

    @Override
    public ResiduoDTO update(Long id, ResiduoDTO dto) {
        Residuo existente = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Residuo no encontrado con id: " + id)
                );
        existente.setCorriente(dto.getCorriente());
        existente.setJuridiccion(dto.getJuridiccion());
        existente.setDetalle(dto.getDetalle());
        Residuo actualizado = repository.save(existente);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Residuo no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}