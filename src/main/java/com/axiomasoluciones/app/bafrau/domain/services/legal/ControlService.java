package com.axiomasoluciones.app.bafrau.domain.services.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;

import java.util.List;

public interface ControlService {

    ControlDTO crearControl(ControlDTO controlDTO);

    List<ControlDTO> obtenerTodos();

    ControlDTO obtenerPorId(Long id);

    void eliminarControl(Long id);
}

