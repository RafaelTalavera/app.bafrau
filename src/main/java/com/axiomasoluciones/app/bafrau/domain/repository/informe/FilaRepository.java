package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Fila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilaRepository extends JpaRepository<Fila, Long> {
    List<Fila> findByTablaIdOrderByNumeroFilaAsc(Long tablaId);

    @Query("""
           select distinct f
           from Fila f
           left join fetch f.celdas c
           where f.tabla.id in :tablaIds
           order by f.tabla.id asc, f.numeroFila asc, c.numeroColumna asc
           """)
    List<Fila> findByTablaIdInWithCeldas(@Param("tablaIds") List<Long> tablaIds);
}
