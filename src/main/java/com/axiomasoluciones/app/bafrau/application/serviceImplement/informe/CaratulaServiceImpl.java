package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CaratulaDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.CaratulaIMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.AdjuntoIMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Caratula;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.CaratulaRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.InformeRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.utility.AdjuntoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.CaratulaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CaratulaServiceImpl implements CaratulaService {

    private final CaratulaRepository repository;
    private final InformeRepository informeRepository;
    private final CaratulaIMapper mapper;
    private final AdjuntoRepository adjuntoRepo;
    private final AdjuntoIMapper adjuntoMapper;

    @Autowired
    public CaratulaServiceImpl(CaratulaRepository repository,
                               InformeRepository informeRepository,
                               CaratulaIMapper mapper,
                               AdjuntoRepository adjuntoRepo,
                               AdjuntoIMapper adjuntoMapper) {
        this.repository = repository;
        this.informeRepository = informeRepository;
        this.mapper = mapper;
        this.adjuntoRepo = adjuntoRepo;
        this.adjuntoMapper = adjuntoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CaratulaDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CaratulaDTO> findByInformeId(Long informeId) {
        return repository.findByInformeId(informeId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CaratulaDTO findById(Long id) {
        Caratula c = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carátula no encontrada con id: " + id));
        return mapper.toDto(c);
    }

    @Override
    public CaratulaDTO create(Long informeId, CaratulaDTO dto) {
        Informe inf = informeRepository.findById(informeId)
                .orElseThrow(() -> new EntityNotFoundException("Informe no encontrado id: " + informeId));

        // 1) Mapear Carátula y adjuntos nuevos
        Caratula entity = mapper.toEntity(dto);
        if (dto.getAdjuntos() != null) {
            dto.getAdjuntos().forEach(adDto -> {
                Adjunto a = adjuntoMapper.toEntity(adDto);
                a.setCaratula(entity);
                entity.getAdjuntos().add(a);
            });
        }

        // 2) Asignar padre y guardar todo en bloque
        entity.setInforme(inf);
        Caratula saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public CaratulaDTO update(Long id, CaratulaDTO dto) {
        Caratula existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carátula no encontrada con id: " + id));

        // 1) Actualizar campos simples
        existing.setTitulo(dto.getTitulo());
        existing.setElaborador(dto.getElaborador());
        existing.setFecha(dto.getFecha());

        // 2) Gestionar adjuntos SIN reemplazar la lista completa
        List<Adjunto> actuales = existing.getAdjuntos();

        // 2.1) Eliminar los que ya no existen en dto.adjuntosIds
        actuales.removeIf(adj -> !dto.getAdjuntosIds().contains(adj.getId()));

        // 2.2) Añadir los nuevos
        for (Long newId : dto.getAdjuntosIds()) {
            boolean existe = actuales.stream()
                    .anyMatch(adj -> adj.getId().equals(newId));
            if (!existe) {
                Adjunto a = adjuntoRepo.getReferenceById(newId);
                a.setCaratula(existing);
                actuales.add(a);
            }
        }

        // 3) Guardar y devolver
        Caratula saved = repository.save(existing);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Carátula no encontrada con id: " + id);
        }
        repository.deleteById(id);
    }
}
