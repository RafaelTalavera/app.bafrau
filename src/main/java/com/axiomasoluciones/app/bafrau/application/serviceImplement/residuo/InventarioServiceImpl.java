package com.axiomasoluciones.app.bafrau.application.serviceImplement.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.InventarioDTO;
import com.axiomasoluciones.app.bafrau.application.dto.residuo.ItemInventarioDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.residuo.InventarioMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.residuo.ItemInventarioMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.entities.residuo.Inventario;
import com.axiomasoluciones.app.bafrau.domain.entities.residuo.Residuo;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.residuo.InventarioRepository;
import com.axiomasoluciones.app.bafrau.domain.services.residuo.InventarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository repository;
    private final InventarioMapper mapper;
    private final ItemInventarioMapper itemMapper;
    private final OrganizacionRepository organizacionRepository;

    @Autowired
    public InventarioServiceImpl(InventarioRepository repository,
                                 InventarioMapper mapper,
                                 ItemInventarioMapper itemMapper,
                                 OrganizacionRepository organizacionRepository) {
        this.repository              = repository;
        this.mapper                  = mapper;
        this.itemMapper              = itemMapper;
        this.organizacionRepository  = organizacionRepository;
    }


    @Override
    public List<InventarioDTO> findAll() {
        // repository.findAll() devuelve Iterable, así evitamos el .stream() directo
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InventarioDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Inventario no encontrado con id: " + id)
                );
    }

    @Override
    public InventarioDTO create(InventarioDTO dto) {
        // 1. Mapear a entidad sin relación
        Inventario entity = mapper.toEntity(dto);

        // 2. Cargar la Organización desde BD (usa el findById heredado)
        Organizacion org = organizacionRepository
                .findById(dto.getOrganizacionId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Organización no existe: " + dto.getOrganizacionId())
                );
        entity.setOrganizacion(org);

        // 3. Asegurar el back‐reference en los ítems
        entity.getItems().forEach(item -> item.setInventario(entity));

        // 4. Persistir
        Inventario saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    @Transactional
    public InventarioDTO update(Long id, InventarioDTO dto) {
        Inventario existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Inventario no encontrado con id: " + id)
                );
        // Mapeo completo y reasigno el id
        Inventario toSave = mapper.toEntity(dto);
        toSave.setId(existing.getId());
        toSave.getItems().forEach(item -> item.setInventario(toSave));
        Inventario updated = repository.save(toSave);
        return mapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Inventario no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemInventarioDTO> findItemsByInventario(Long inventarioId) {
        Inventario inv = repository.findById(inventarioId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Inventario no encontrado con id: " + inventarioId
                ));
        return inv.getItems().stream()
                .map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }
}