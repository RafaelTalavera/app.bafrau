package com.axiomasoluciones.app.bafrau.domain.services.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.ResiduoDTO;

import java.util.List;

public interface ResiduoService {

    List<ResiduoDTO> findAll();

    ResiduoDTO findById(Long id);

    ResiduoDTO create(ResiduoDTO dto);


    ResiduoDTO update(Long id, ResiduoDTO dto);

    void delete(Long id);
}
