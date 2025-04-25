package com.axiomasoluciones.app.bafrau.domain.repository.utility;

import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdjuntoRepository extends CrudRepository<Adjunto, Long> {

    List<Adjunto> findByOrganizacionId(Long organizacionId);
}
