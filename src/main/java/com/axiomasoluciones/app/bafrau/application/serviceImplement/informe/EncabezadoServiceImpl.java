package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.EncabezadoDTO;

import com.axiomasoluciones.app.bafrau.application.mappers.informe.EncabezadoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Encabezado;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.StyleTemplate;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.EncabezadoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.EncabezadoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EncabezadoServiceImpl implements EncabezadoService {

    private final EncabezadoRepository repo;
    private final EncabezadoMapper mapper;

    public EncabezadoServiceImpl(EncabezadoRepository repo, EncabezadoMapper mapper) {
        this.repo   = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EncabezadoDTO> findAll() {
        return repo.findAllWithAdjuntos().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EncabezadoDTO findById(Long id) {
        Encabezado e = repo.findByIdWithAdjuntos(id)
                .orElseThrow(() -> new RuntimeException("Encabezado no encontrado: " + id));
        return mapper.toDto(e);
    }

    @Override
    public EncabezadoDTO create(EncabezadoDTO dto) {
        Encabezado e = mapper.toEntity(dto);
        // si gestionas adjuntos por separado, límpialos antes de guardar:
        // e.getAdjuntos().clear();
        Encabezado saved = repo.save(e);
        return mapper.toDto(saved);
    }

    @Override
    public EncabezadoDTO update(Long id, EncabezadoDTO dto) {
        Encabezado existing = repo.findByIdWithAdjuntos(id)
                .orElseThrow(() -> new RuntimeException("Encabezado no encontrado: " + id));

        existing.setContenido(dto.getContenido());

        // En lugar de new Informe(Long), usa el ctor vacío + setter:
        Informe informe = new Informe();
        informe.setId(dto.getInformeId());
        existing.setInforme(informe);

        // si sincronizas adjuntos, hazlo aquí...
        Encabezado updated = repo.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Encabezado no encontrado: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EncabezadoDTO> findByInformeId(Long informeId) {
        return repo.findByInformeIdWithAdjuntos(informeId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}