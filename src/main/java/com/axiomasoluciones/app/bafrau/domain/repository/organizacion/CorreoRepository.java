package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Correo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CorreoRepository extends CrudRepository<Correo, Long> {

    List<Correo> findByOrganizacionId(Long organizacionId);
}
