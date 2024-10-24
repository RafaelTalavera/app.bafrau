package com.axiomasoluciones.app.bafrau.domain.services.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.FactorDTO;

import java.util.List;
import java.util.Optional;

public interface IFactorService {
    List<FactorDTO> findAll();
    Optional<FactorDTO> findById(Long id);
    FactorDTO create(FactorDTO factorDTO);
    FactorDTO update(Long id, FactorDTO factorDTO);
    void deleteById(Long id);
}

