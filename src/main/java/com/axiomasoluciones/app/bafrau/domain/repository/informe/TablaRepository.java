package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Tabla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TablaRepository extends JpaRepository<Tabla, Long> {
    List<Tabla> findBySeccionId(Long seccionId);

    @Query("""
           select t
           from Tabla t
           where t.seccion.id in :seccionIds
           """)
    List<Tabla> findBySeccionIdIn(@Param("seccionIds") List<Long> seccionIds);
}