package com.axiomasoluciones.app.bafrau.domain.services.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.NominaEmpleadosDTO;
import java.util.List;

public interface NominaEmpleadosService {

    List<NominaEmpleadosDTO> getAllNominaEmpleados();

    NominaEmpleadosDTO getNominaEmpleadoById(Long id);

    NominaEmpleadosDTO createNominaEmpleado(NominaEmpleadosDTO nominaEmpleadosDTO);

    NominaEmpleadosDTO updateNominaEmpleado(Long id, NominaEmpleadosDTO nominaEmpleadosDTO);

    void deleteNominaEmpleado(Long id);

    List<NominaEmpleadosDTO> getNominaEmpleadosByInformeId(Long informeId);
}