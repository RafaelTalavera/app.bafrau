package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.NominaEmpleadosDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.SectorDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Sector;

import java.util.List;

public interface SectorService {

    List<SectorDTO> findAll();

    SectorDTO findById(Long id);

    SectorDTO save(SectorDTO sectorDTO);

    SectorDTO update(Long id, SectorDTO sectorDTO);

    void deleteById(Long id);

    List<SectorDTO> getSectorByInformeId(Long informeId);
}