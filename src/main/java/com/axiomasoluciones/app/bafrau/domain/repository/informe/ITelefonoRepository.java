package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Telefono;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITelefonoRepository extends CrudRepository<Telefono, Long> {

    List<Telefono> findByInformeId(Long informeId);
}
