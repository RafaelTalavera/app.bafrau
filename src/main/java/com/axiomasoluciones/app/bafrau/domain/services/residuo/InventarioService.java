package com.axiomasoluciones.app.bafrau.domain.services.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.InventarioDTO;
import com.axiomasoluciones.app.bafrau.application.dto.residuo.ItemInventarioDTO;

import java.util.List;

public interface InventarioService {

    List<InventarioDTO> findAll();

    InventarioDTO findById(Long id);

    InventarioDTO create(InventarioDTO dto);

    InventarioDTO update(Long id, InventarioDTO dto);

    void delete(Long id);

    List<ItemInventarioDTO> findItemsByInventario(Long inventarioId);

}