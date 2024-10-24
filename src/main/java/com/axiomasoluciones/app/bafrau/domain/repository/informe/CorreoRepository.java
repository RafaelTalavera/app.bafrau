package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Correo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CorreoRepository extends CrudRepository<Correo, Long> {

    List<Correo> findByInformeId(Long informeId);
}
