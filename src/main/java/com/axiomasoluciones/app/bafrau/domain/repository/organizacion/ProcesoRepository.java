package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Proceso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcesoRepository extends CrudRepository<Proceso, Long> {

    List<Proceso> findByOrganizacionId(Long organizacionId);
}
