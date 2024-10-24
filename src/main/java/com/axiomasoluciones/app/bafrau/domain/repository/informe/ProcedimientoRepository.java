package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Procedimiento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcedimientoRepository extends CrudRepository<Procedimiento, Long> {

    List<Procedimiento> findByInforme_Id(Long informeId);
}
