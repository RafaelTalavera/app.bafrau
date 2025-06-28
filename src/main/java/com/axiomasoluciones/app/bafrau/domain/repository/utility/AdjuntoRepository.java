package com.axiomasoluciones.app.bafrau.domain.repository.utility;

import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AdjuntoRepository
        extends JpaRepository<Adjunto, Long> {
    List<Adjunto> findByOrganizacionId(Long organizacionId);
}
