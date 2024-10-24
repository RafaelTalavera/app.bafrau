package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcesoDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.SectorDTO;

import java.util.List;

public interface ProcesoService {

    List<ProcesoDTO> findAll();

    ProcesoDTO findById(Long id);

    ProcesoDTO save(ProcesoDTO procesoDTO);

    ProcesoDTO update(Long id, ProcesoDTO procesoDTO);

    void deleteById(Long id);

    List<ProcesoDTO> getProcesoByInformeId(Long informeId);
}
