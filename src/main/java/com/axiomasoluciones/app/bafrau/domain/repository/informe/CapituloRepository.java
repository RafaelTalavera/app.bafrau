package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo.CapituloLightDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Capitulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CapituloRepository extends CrudRepository<Capitulo, Long> {

    @Query("""
    select new com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo.CapituloLightDTO(
       c.id, c.titulo, c.orden, c.informe.id
    )
    from Capitulo c
    where c.informe.id = :informeId
    order by c.orden asc
  """)
    List<CapituloLightDTO> findLightByInformeIdOrderByOrdenAsc(@Param("informeId") Long informeId);
}