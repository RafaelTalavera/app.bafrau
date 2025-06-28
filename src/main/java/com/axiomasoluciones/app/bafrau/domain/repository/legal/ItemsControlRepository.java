package com.axiomasoluciones.app.bafrau.domain.repository.legal;

import com.axiomasoluciones.app.bafrau.domain.entities.legal.ItemControl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemsControlRepository extends CrudRepository<ItemControl, Long> {

    @Query("select i from ItemControl i left join fetch i.listMail")
    List<ItemControl> findAllWithMails();

    @Query("select i from ItemControl i where i.control.organizacion.id = :orgId")
    List<ItemControl> findByOrganizacionId(Long orgId);

}
