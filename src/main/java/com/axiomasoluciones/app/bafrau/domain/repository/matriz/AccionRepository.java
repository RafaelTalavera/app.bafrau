package com.axiomasoluciones.app.bafrau.domain.repository.matriz;

import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Accion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccionRepository extends CrudRepository<Accion, Long> {

    List<Accion> findByClasificacion(String clasificacion);
}
