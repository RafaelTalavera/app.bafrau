package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Encabezado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EncabezadoRepository extends JpaRepository<Encabezado, Long> {

    @Query("SELECT e FROM Encabezado e " +
            "LEFT JOIN FETCH e.adjuntos a " +
            "WHERE e.informe.id = :informeId " +
            "ORDER BY e.createdDate")
    List<Encabezado> findByInformeIdWithAdjuntos(@Param("informeId") Long informeId);

    @Query("SELECT e FROM Encabezado e LEFT JOIN FETCH e.adjuntos")
    List<Encabezado> findAllWithAdjuntos();

    @Query("SELECT e FROM Encabezado e LEFT JOIN FETCH e.adjuntos WHERE e.id = :id")
    Optional<Encabezado> findByIdWithAdjuntos(@Param("id") Long id);
}
