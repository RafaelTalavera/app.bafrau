package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.InformeIMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.InformeRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.InformeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class InformeServiceImpl implements InformeService {

    private final InformeRepository repository;
    private final InformeIMapper mapper;

    public InformeServiceImpl(InformeRepository repository, InformeIMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InformeDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public InformeDTO findById(Long id) {
        Informe informe = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Informe no encontrado con id: " + id));
        return mapper.toDto(informe);
    }

    @Override
    public InformeDTO create(InformeDTO informeDTO) {
        Informe informe = mapper.toEntity(informeDTO);
        Informe saved = repository.save(informe);
        return mapper.toDto(saved);
    }

    @Override
    public InformeDTO update(Long id, InformeDTO informeDTO) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Informe no encontrado con id: " + id);
        }
        Informe toUpdate = mapper.toEntity(informeDTO);
        toUpdate.setId(id);
        Informe updated = repository.save(toUpdate);
        return mapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Informe no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}
