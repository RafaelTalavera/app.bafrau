package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Telefono;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TelefonoRepository extends CrudRepository<Telefono, Long> {

    List<Telefono> findByOrganizacionId(Long organizacionId);
}
