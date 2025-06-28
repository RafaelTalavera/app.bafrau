package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.EncabezadoDTO;
import java.util.List;

public interface EncabezadoService {
    List<EncabezadoDTO> findAll();
    EncabezadoDTO findById(Long id);
    EncabezadoDTO create(EncabezadoDTO dto);
    EncabezadoDTO update(Long id, EncabezadoDTO dto);
    void delete(Long id);
    List<EncabezadoDTO> findByInformeId(Long informeId);
}
