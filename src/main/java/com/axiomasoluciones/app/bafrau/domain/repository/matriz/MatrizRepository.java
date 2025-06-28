package com.axiomasoluciones.app.bafrau.domain.repository.matriz;

import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MatrizRepository extends JpaRepository<Matriz, Long> {

    @Query("SELECT DISTINCT m " +
            "FROM Matriz m " +
            "LEFT JOIN FETCH m.items i " +
            "LEFT JOIN FETCH i.accion a " +
            "LEFT JOIN FETCH i.factor f")
    List<Matriz> findAllWithItems();

    @Query("SELECT m " +
            "FROM Matriz m " +
            "LEFT JOIN FETCH m.items i " +
            "LEFT JOIN FETCH i.accion a " +
            "LEFT JOIN FETCH i.factor f " +
            "WHERE m.id = :id")
    Optional<Matriz> findByIdWithItems(@Param("id") Long id);


}
