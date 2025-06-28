package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.NominaEmpleados;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NominaEmpleadosRepository extends CrudRepository<NominaEmpleados, Long> {
    List<NominaEmpleados> findByOrganizacionId(Long organizacionId);
}