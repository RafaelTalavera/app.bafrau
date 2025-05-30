package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcedimientoDTO;
import java.util.List;

public interface ProcedimientoService {

    ProcedimientoDTO createProcedimiento(ProcedimientoDTO procedimientoDTO);

    ProcedimientoDTO getProcedimientoById(Long id);

    List<ProcedimientoDTO> getAllProcedimientos();

    ProcedimientoDTO updateProcedimiento(Long id, ProcedimientoDTO procedimientoDTO);

    void deleteProcedimientoById(Long id);

    List<ProcedimientoDTO> getProcedimientosByOrganizacionId(Long organizacionId);
}