package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CapituloDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenCapituloDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.OrdenSeccionDTO;

import java.util.List;

public interface CapituloService {

    List<CapituloDTO> findAll();

    CapituloDTO findById(Long id);

    CapituloDTO create(CapituloDTO capituloDTO);

    CapituloDTO update(Long id, CapituloDTO capituloDTO);

    void delete(Long id);

    void updateOrdenes(List<OrdenCapituloDTO> ordenes);
}
