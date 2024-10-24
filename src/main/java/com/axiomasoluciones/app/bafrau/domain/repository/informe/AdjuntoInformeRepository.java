package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.AdjuntoInforme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdjuntoInformeRepository extends CrudRepository<AdjuntoInforme, Long> {

    List<AdjuntoInforme> findByInformeId(Long informeId);
}
