package com.axiomasoluciones.app.bafrau.application.serviceImplement.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.AccionDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.matriz.AccionMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Accion;
import com.axiomasoluciones.app.bafrau.domain.repository.matriz.AccionRepository;
import com.axiomasoluciones.app.bafrau.domain.services.matriz.IAccionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccionServiceImpl implements IAccionService {

    private final AccionRepository accionRepository;
    private final AccionMapper accionMapper;

    public AccionServiceImpl(AccionRepository accionRepository, AccionMapper accionMapper) {
        this.accionRepository = accionRepository;
        this.accionMapper = accionMapper;
    }

    @Override
    public List<AccionDTO> findAll() {
        return ((List<Accion>) accionRepository.findAll())
                .stream()
                .map(accionMapper::toAccionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AccionDTO> findById(Long id) {
        return accionRepository.findById(id).map(accionMapper::toAccionDTO);
    }

    @Override
    public AccionDTO create(AccionDTO accionDTO) {
        Accion accion = accionMapper.toAccion(accionDTO);
        return accionMapper.toAccionDTO(accionRepository.save(accion));
    }

    @Override
    public AccionDTO update(Long id, AccionDTO accionDTO) {
        Accion accion = accionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acción no encontrada con ID: " + id));

        accion.setClasificacion(accionDTO.getClasificacion());
        accion.setTipo(accionDTO.getTipo());
        return accionMapper.toAccionDTO(accionRepository.save(accion));
    }

    @Override
    public void deleteById(Long id) {
        if (!accionRepository.existsById(id)) {
            throw new RuntimeException("Acción no encontrada con ID: " + id);
        }
        accionRepository.deleteById(id);
    }

    @Override
    public List<AccionDTO> findByClasificacion(String query) {
        return accionRepository.findByClasificacionContainingIgnoreCase(query)
                .stream()
                .map(accionMapper::toAccionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccionDTO> findByTipo(String query) {
        return accionRepository.findByTipoContainingIgnoreCase(query)
                .stream()
                .map(accionMapper::toAccionDTO)
                .collect(Collectors.toList());
    }


}
