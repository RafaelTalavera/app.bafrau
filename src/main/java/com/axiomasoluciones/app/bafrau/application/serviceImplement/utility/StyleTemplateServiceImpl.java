package com.axiomasoluciones.app.bafrau.application.serviceImplement.utility;


import com.axiomasoluciones.app.bafrau.application.dto.utility.StyleTemplateDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.StyleTemplateMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.StyleTemplate;

import com.axiomasoluciones.app.bafrau.domain.repository.utility.StyleTemplateRepository;
import com.axiomasoluciones.app.bafrau.domain.services.utility.StyleTemplateService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StyleTemplateServiceImpl implements StyleTemplateService {

    private final StyleTemplateRepository repository;
    private final StyleTemplateMapper mapper;

    public StyleTemplateServiceImpl(StyleTemplateRepository repository, StyleTemplateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<StyleTemplateDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StyleTemplateDTO findeById(Long id) {
        StyleTemplate entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estilo no encontrado con id " + id));
        return mapper.toDto(entity);
    }

    @Override
    public StyleTemplateDTO save(StyleTemplateDTO dto) {
        StyleTemplate saved = repository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @Override
    public StyleTemplateDTO update(Long id, StyleTemplateDTO dto) {
        StyleTemplate existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estilo no encontrado con id " + id));
        StyleTemplate updated = mapper.toEntity(dto);
        updated.setId(id);
        return mapper.toDto(repository.save(updated));
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}