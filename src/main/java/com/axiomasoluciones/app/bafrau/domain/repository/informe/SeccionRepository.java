package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Seccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeccionRepository extends CrudRepository<Seccion, Long> {

    @Query("""
           select distinct s
           from Seccion s
           left join fetch s.adjuntos a
           left join fetch s.styleTemplate st
           where s.capitulo.informe.id = :informeId
           order by s.capitulo.id asc, s.orden asc
           """)
    List<Seccion> findByInformeIdWithAdjuntosAndStyle(@Param("informeId") Long informeId);

}
