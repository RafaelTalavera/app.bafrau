package com.axiomasoluciones.app.bafrau.domain.services.informe;


import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import java.util.List;

public interface InformeService {

    List<InformeDTO> findAll();

    InformeDTO findById(Long id);

    InformeDTO create(InformeDTO informeDTO);

    InformeDTO update(Long id, InformeDTO informeDTO);

    void delete(Long id);
}
