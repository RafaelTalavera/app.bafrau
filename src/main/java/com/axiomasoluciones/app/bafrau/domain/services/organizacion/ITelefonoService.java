package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.TelefonoDTO;
import java.util.List;
import java.util.Optional;

public interface ITelefonoService {

    List<TelefonoDTO> findAll();

    Optional<TelefonoDTO> findById(Long id);

    TelefonoDTO create(TelefonoDTO telefonoDTO);

    TelefonoDTO update(Long id, TelefonoDTO telefonoDTO);

    void delete(Long id);

    List<TelefonoDTO> getTelefonosByOrganizacionId(Long organizacionId);
}
