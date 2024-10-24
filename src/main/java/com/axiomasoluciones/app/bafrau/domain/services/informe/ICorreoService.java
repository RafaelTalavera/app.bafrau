package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CorreoDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.TelefonoDTO;

import java.util.List;
import java.util.Optional;

public interface ICorreoService {
    List<CorreoDTO> findAll();
    Optional<CorreoDTO> findById(Long id);
    CorreoDTO create(CorreoDTO correoDTO);
    CorreoDTO update(Long id, CorreoDTO correoDTO);
    void delete(Long id);
    List<CorreoDTO> getCorreosByInformeId(Long informeId);
}
