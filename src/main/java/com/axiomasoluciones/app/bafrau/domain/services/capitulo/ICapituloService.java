package com.axiomasoluciones.app.bafrau.domain.services.capitulo;

import com.axiomasoluciones.app.bafrau.application.dto.capitulo.CapituloDTO;

import java.util.List;
import java.util.Optional;

public interface ICapituloService {
    List<CapituloDTO> findAll();
    Optional<CapituloDTO> findById(Long id);
    CapituloDTO create(CapituloDTO capituloDTO);
    CapituloDTO update(Long id, CapituloDTO capituloDTO);
    void deleteById(Long id);
}
