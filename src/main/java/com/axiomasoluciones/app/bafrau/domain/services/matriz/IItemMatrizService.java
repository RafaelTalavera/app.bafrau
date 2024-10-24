package com.axiomasoluciones.app.bafrau.domain.services.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.ItemMatrizDTO;

import java.util.List;
import java.util.Optional;

public interface IItemMatrizService {
    List<ItemMatrizDTO> findAll();
    Optional<ItemMatrizDTO> findById(Long id);
    ItemMatrizDTO create(ItemMatrizDTO itemMatrizDTO);
    ItemMatrizDTO update(Long id, ItemMatrizDTO itemMatrizDTO);
    void deleteById(Long id);
}
