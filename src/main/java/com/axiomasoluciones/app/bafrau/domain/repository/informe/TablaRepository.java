package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Tabla;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TablaRepository extends JpaRepository<Tabla, Long> {
    List<Tabla> findBySeccionId(Long seccionId);
}