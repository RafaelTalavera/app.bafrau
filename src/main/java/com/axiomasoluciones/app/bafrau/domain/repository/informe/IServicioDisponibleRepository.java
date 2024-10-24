package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.ServicioDisponible;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IServicioDisponibleRepository extends CrudRepository<ServicioDisponible, Long> {

    List<ServicioDisponible> findByInformeId(Long informeId);
}
