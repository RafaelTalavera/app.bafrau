package com.axiomasoluciones.app.bafrau.domain.services.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.AccionDTO;

import java.util.List;
import java.util.Optional;

public interface IAccionService {
    List<AccionDTO> findAll();
    Optional<AccionDTO> findById(Long id);
    AccionDTO create(AccionDTO accionDTO);
    AccionDTO update(Long id, AccionDTO accionDTO);
    void deleteById(Long id);
}
