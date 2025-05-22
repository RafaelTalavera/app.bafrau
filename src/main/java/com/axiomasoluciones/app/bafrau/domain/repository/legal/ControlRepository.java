package com.axiomasoluciones.app.bafrau.domain.repository.legal;

import com.axiomasoluciones.app.bafrau.domain.entities.legal.Control;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ControlRepository extends CrudRepository<Control,Long> {

    @Query("SELECT DISTINCT c FROM Control c LEFT JOIN FETCH c.items")
    List<Control> findAllWithItems();
}
