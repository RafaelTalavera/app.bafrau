package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo.CapituloDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo.CapituloLightDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenCapituloDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.CapituloIMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Capitulo;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.CapituloRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.CapituloService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CapituloServiceImpl implements CapituloService {

    private final CapituloRepository repository;
    private final CapituloIMapper mapper;

    public CapituloServiceImpl(CapituloRepository repository, CapituloIMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CapituloDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CapituloDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Capítulo no encontrado con id: " + id));
    }

    @Override
    public CapituloDTO create(CapituloDTO capituloDTO) {
        var entity = mapper.toEntity(capituloDTO);
        var saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public CapituloDTO update(Long id, CapituloDTO capituloDTO) {
        // 1) Buscamos la entidad existente en BD
        Capitulo existing = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Capítulo no encontrado con id: " + id)
                );

        // 2) Actualizamos sólo los campos sencillos
        existing.setTitulo(capituloDTO.getTitulo());
        existing.setOrden(capituloDTO.getOrden());
        // (Si necesitaras permitir cambiar informeId, descomenta la línea siguiente)
        // existing.getInforme().setId(capituloDTO.getInformeId());

        // 3) NO tocamos la lista de secciones: la dejamos intacta para que no se eliminen
        // existing.getSecciones() sigue conteniendo las Seccion persistidas

        // 4) Guardamos y devolvemos DTO
        Capitulo saved = repository.save(existing);
        return mapper.toDto(saved);
    }


    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Capítulo no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public void updateOrdenes(List<OrdenCapituloDTO> ordenes) {
        // 1) IDs a actualizar
        List<Long> ids = ordenes.stream()
                .map(OrdenCapituloDTO::getId)
                .collect(Collectors.toList());

        // 2) Obtener Iterable<Seccion>
        Iterable<Capitulo> iterable = repository.findAllById(ids);

        // 3) Convertir a List<Seccion>
        List<Capitulo> entidades = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        // 4) Mapear id → orden y actualizar
        Map<Long, Integer> mapa = ordenes.stream()
                .collect(Collectors.toMap(OrdenCapituloDTO::getId, OrdenCapituloDTO::getOrden));
        entidades.forEach(s -> s.setOrden(mapa.get(s.getId())));

        // 5) Guardar en bloque
        repository.saveAll(entidades);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CapituloLightDTO> findLightByInformeId(Long informeId) {
        return repository.findLightByInformeIdOrderByOrdenAsc(informeId);
    }
}
