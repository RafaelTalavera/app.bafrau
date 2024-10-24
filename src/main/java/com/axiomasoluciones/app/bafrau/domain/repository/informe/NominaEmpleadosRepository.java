package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.NominaEmpleados;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NominaEmpleadosRepository extends CrudRepository<NominaEmpleados, Long> {
    List<NominaEmpleados> findByInformeId(Long informeId);
}