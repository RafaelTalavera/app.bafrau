package com.axiomasoluciones.app.bafrau.domain.services.seccion;

import com.axiomasoluciones.app.bafrau.application.dto.seccion.SeccionDTO;

import java.util.List;
import java.util.Optional;

public interface ISeccionService {
    List<SeccionDTO> findAll();
    Optional<SeccionDTO> findById(Long id);
    SeccionDTO create(SeccionDTO seccionDTO);
    SeccionDTO update(Long id, SeccionDTO seccionDTO);
    void deleteById(Long id);
}
