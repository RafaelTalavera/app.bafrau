package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Procedimiento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcedimientoRepository extends CrudRepository<Procedimiento, Long> {

    List<Procedimiento> findByOrganizacion_Id(Long organizacionId);
}
