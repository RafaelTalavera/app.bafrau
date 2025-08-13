package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import org.springframework.data.repository.CrudRepository;
import com.axiomasoluciones.app.bafrau.application.dto.informe.informe.InformeListItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InformeRepository extends CrudRepository<Informe, Long> {

    @Query("""
           select new com.axiomasoluciones.app.bafrau.application.dto.informe.informe.InformeListItemDTO(
               i.id,
               i.titulo,
               i.organizacion.razonSocial,
               i.fecha,
               i.organizacion.id
           )
           from Informe i
           """)
    List<InformeListItemDTO> findAllSummary();

    @Query("""
           select new com.axiomasoluciones.app.bafrau.application.dto.informe.informe.InformeListItemDTO(
               i.id,
               i.titulo,
               i.organizacion.razonSocial,
               i.fecha,
               i.organizacion.id
           )
           from Informe i
           """)
    Page<InformeListItemDTO> findAllSummary(Pageable pageable);
}