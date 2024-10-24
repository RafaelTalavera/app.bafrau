package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Proceso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcesoRepository extends CrudRepository<Proceso, Long> {

    List<Proceso> findByInformeId(Long informeId);
}
