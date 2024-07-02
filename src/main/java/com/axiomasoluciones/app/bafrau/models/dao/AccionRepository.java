package com.axiomasoluciones.app.bafrau.models.dao;

import com.axiomasoluciones.app.bafrau.models.entities.Accion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccionRepository extends CrudRepository<Accion, Long> {

    List<Accion> findByClasificacion(String clasificacion);
}
