package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.SectorDTO;

import java.util.List;

public interface SectorService {

    List<SectorDTO> findAll();

    SectorDTO findById(Long id);

    SectorDTO save(SectorDTO sectorDTO);

    SectorDTO update(Long id, SectorDTO sectorDTO);

    void deleteById(Long id);

    List<SectorDTO> getSectorByOrganizacionId(Long organizacionId);
}