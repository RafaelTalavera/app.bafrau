package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.ServicioDisponible;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IServicioDisponibleRepository extends CrudRepository<ServicioDisponible, Long> {

    List<ServicioDisponible> findByOrganizacionId(Long organizacionId);
}
