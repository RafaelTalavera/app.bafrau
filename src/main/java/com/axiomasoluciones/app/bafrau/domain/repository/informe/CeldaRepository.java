package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Celda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CeldaRepository extends JpaRepository<Celda, Long> {
    List<Celda> findByFilaIdOrderByNumeroColumnaAsc(Long filaId);
}
