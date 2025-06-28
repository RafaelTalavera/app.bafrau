package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenSeccionDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.SeccionDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.SeccionIMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.AdjuntoIMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.SeccionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.utility.AdjuntoRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.utility.StyleTemplateRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.SeccionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class SeccionServiceImpl implements SeccionService {

    private final SeccionRepository repository;
    private final SeccionIMapper mapper;
    private final StyleTemplateRepository styleTemplateRepo;
    private final AdjuntoRepository adjuntoRepo;

    public SeccionServiceImpl(SeccionRepository repository, SeccionIMapper mapper, StyleTemplateRepository styleTemplateRepo, AdjuntoRepository adjuntoRepo) {
        this.repository = repository;
        this.mapper = mapper;
        this.styleTemplateRepo = styleTemplateRepo;
        this.adjuntoRepo = adjuntoRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeccionDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SeccionDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Sección no encontrada con id: " + id));
    }

    @Override
    public SeccionDTO create(SeccionDTO dto) {
        // 1) Mapear Sección + posibles adjuntos nuevos
        Seccion entity = mapper.toEntity(dto);

        // 2) Para cada AdjuntoDTO solo asigno la sección padre
        if (dto.getAdjuntos() != null) {
            dto.getAdjuntos().forEach(adDto -> {
                Adjunto a = AdjuntoIMapper.INSTANCE.toEntity(adDto);
                a.setSeccion(entity);
                // ya no seteamos organización
                entity.getAdjuntos().add(a);
            });
        }

        // 3) Guardar TODO junto (cascade PERSIST)
        Seccion saved = repository.save(entity);

        return mapper.toDto(saved);
    }


    @Override
    @Transactional
    public SeccionDTO update(Long id, SeccionDTO dto) {
        Seccion seccion = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sección no encontrada con id: " + id));

        // 1) Actualizar campos simples
        seccion.setContenido(dto.getContenido());
        seccion.setOrden(dto.getOrden());
        seccion.setStyleTemplate(styleTemplateRepo.getReferenceById(dto.getStyleTemplateId()));

        // 2) Gestionar adjuntos SIN reemplazar la lista
        List<Adjunto> actuales = seccion.getAdjuntos();

        // Eliminar los que fueron quitados
        actuales.removeIf(adj -> !dto.getAdjuntosIds().contains(adj.getId()));

        // Añadir los nuevos
        for (Long newId : dto.getAdjuntosIds()) {
            boolean existe = actuales.stream()
                    .anyMatch(adj -> adj.getId().equals(newId));
            if (!existe) {
                Adjunto a = adjuntoRepo.getReferenceById(newId);
                a.setSeccion(seccion);
                actuales.add(a);
            }
        }

        // 3) Guardar y devolver DTO
        Seccion saved = repository.save(seccion);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Sección no encontrada con id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public void updateOrdenes(List<OrdenSeccionDTO> ordenes) {
        // 1) IDs a actualizar
        List<Long> ids = ordenes.stream()
                .map(OrdenSeccionDTO::getId)
                .collect(Collectors.toList());

        // 2) Obtener Iterable<Seccion>
        Iterable<Seccion> iterable = repository.findAllById(ids);

        // 3) Convertir a List<Seccion>
        List<Seccion> entidades = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        // 4) Mapear id → orden y actualizar
        Map<Long, Integer> mapa = ordenes.stream()
                .collect(Collectors.toMap(OrdenSeccionDTO::getId, OrdenSeccionDTO::getOrden));
        entidades.forEach(s -> s.setOrden(mapa.get(s.getId())));

        // 5) Guardar en bloque
        repository.saveAll(entidades);
    }
}
