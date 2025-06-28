package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcesoDTO;

import java.util.List;

public interface ProcesoService {

    List<ProcesoDTO> findAll();

    ProcesoDTO findById(Long id);

    ProcesoDTO save(ProcesoDTO procesoDTO);

    ProcesoDTO update(Long id, ProcesoDTO procesoDTO);

    void deleteById(Long id);

    List<ProcesoDTO> getProcesoByOrganizacionId(Long organizacionId);
}
