package com.axiomasoluciones.app.bafrau.domain.services.tabla;

import com.axiomasoluciones.app.bafrau.application.dto.tabla.TablaDTO;

import java.util.List;
import java.util.Optional;

public interface ITablaService {
    List<TablaDTO> findAll();
    Optional<TablaDTO> findById(Long id);
    TablaDTO create(TablaDTO tablaDTO);
    TablaDTO update(Long id, TablaDTO tablaDTO);
    void deleteById(Long id);
}

