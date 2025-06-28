package com.axiomasoluciones.app.bafrau.domain.repository.legal;

import com.axiomasoluciones.app.bafrau.domain.entities.legal.Control;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ControlRepository extends CrudRepository<Control,Long> {

    @Query("SELECT DISTINCT c FROM Control c LEFT JOIN FETCH c.items")
    List<Control> findAllWithItems();

    @Query("""
  select distinct c
  from Control c
    left join fetch c.items i
    left join fetch i.listMail m
""")
    List<Control> findAllWithItemsAndMails();

    @EntityGraph(attributePaths = {"items.listMail"})
    List<Control> findAll();

}
