package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.InsumoDTO;

import java.util.List;

public interface InsumoService {

    List<InsumoDTO> findAll();

    InsumoDTO findById(Long id);

    InsumoDTO save(InsumoDTO insumoDTO);

    InsumoDTO update(Long id, InsumoDTO insumoDTO);

    void deleteById(Long id);

    List<InsumoDTO> getInsumosByProcesoId(Long procesoId);

    List<InsumoDTO> getInsumoByOrganizacionId(Long organizacionId);
}

