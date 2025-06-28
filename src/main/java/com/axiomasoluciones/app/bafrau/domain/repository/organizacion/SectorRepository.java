package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Sector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectorRepository extends CrudRepository<Sector, Long> {

    List<Sector> findByOrganizacionId(Long organizacionId);
}
