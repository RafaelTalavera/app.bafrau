package com.axiomasoluciones.app.bafrau.domain.repository.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.InventarioDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.residuo.Inventario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventarioRepository extends CrudRepository<Inventario, Long> {

    @Query("SELECT new com.axiomasoluciones.app.bafrau.application.dto.residuo.InventarioDTO(" +
            "i.id, i.fecha, i.organizacion.id, i.contrato) " +
            "FROM Inventario i")
    List<InventarioDTO> findAllDTO();

}
