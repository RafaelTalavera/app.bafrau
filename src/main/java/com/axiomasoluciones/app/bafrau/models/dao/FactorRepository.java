package com.axiomasoluciones.app.bafrau.models.dao;

import com.axiomasoluciones.app.bafrau.models.entities.Factor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FactorRepository extends CrudRepository<Factor, Long> {
    List<Factor> findByClasificacion(String clasificacion);
}
