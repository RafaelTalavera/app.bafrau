package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Caratula;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CaratulaRepository extends CrudRepository<Caratula, Long> {
    // --- CAMBIO: buscar por informeId ---
    List<Caratula> findByInformeId(Long informeId);
}
