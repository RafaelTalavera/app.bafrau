package com.axiomasoluciones.app.bafrau.domain.repository.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InformeRepository extends CrudRepository<Informe, Long> {

    @Query("SELECT i FROM Informe i WHERE i.user.organizacion = :organizacion")
    List<Informe> findAllByUserOrganizacion(@Param("organizacion") String organizacion);

    @Query("SELECT i.id, i.razonSocial FROM Informe i")
    List<Object[]> findAllRazonesSociales();

}
