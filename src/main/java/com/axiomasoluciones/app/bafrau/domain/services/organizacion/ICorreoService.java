package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.CorreoDTO;

import java.util.List;
import java.util.Optional;

public interface ICorreoService {

    List<CorreoDTO> findAll();

    Optional<CorreoDTO> findById(Long id);

    CorreoDTO create(CorreoDTO correoDTO);

    CorreoDTO update(Long id, CorreoDTO correoDTO);

    void delete(Long id);

    List<CorreoDTO> getCorreosByOrganizacionId(Long organizacionId);
}
