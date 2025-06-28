package com.axiomasoluciones.app.bafrau.domain.services.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.NominaEmpleadosDTO;
import java.util.List;

public interface NominaEmpleadosService {

    List<NominaEmpleadosDTO> getAllNominaEmpleados();

    NominaEmpleadosDTO getNominaEmpleadoById(Long id);

    NominaEmpleadosDTO createNominaEmpleado(NominaEmpleadosDTO nominaEmpleadosDTO);

    NominaEmpleadosDTO updateNominaEmpleado(Long id, NominaEmpleadosDTO nominaEmpleadosDTO);

    void deleteNominaEmpleado(Long id);

    List<NominaEmpleadosDTO> getNominaEmpleadosByOrganizacionId(Long organiacionId);
}