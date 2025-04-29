package com.axiomasoluciones.app.bafrau.domain.repository.organizacion;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizacionRepository extends CrudRepository<Organizacion, Long> {

    @Query("SELECT i FROM Organizacion i WHERE i.user.organizacion = :organizacion")
    List<Organizacion> findAllByUserOrganizacion(@Param("organizacion") String organizacion);

    @Query("SELECT i.id, i.razonSocial FROM Organizacion i")
    List<Object[]> findAllRazonesSociales();

    List<Organizacion> findAllByTipoDeContrato(String tipoDeContrato);

}
