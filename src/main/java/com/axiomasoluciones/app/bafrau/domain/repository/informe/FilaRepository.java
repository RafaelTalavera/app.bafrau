package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Fila;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilaRepository extends JpaRepository<Fila, Long> {
    List<Fila> findByTablaIdOrderByNumeroFilaAsc(Long tablaId);
}
