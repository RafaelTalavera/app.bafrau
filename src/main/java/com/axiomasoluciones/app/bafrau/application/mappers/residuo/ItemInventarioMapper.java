package com.axiomasoluciones.app.bafrau.application.mappers.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.ItemInventarioDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.residuo.ItemInventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemInventarioMapper {
    @Mapping(target = "residuo.id",     source = "residuo.id")
    @Mapping(target = "inventario.id", source = "inventarioId")
    ItemInventario toEntity(ItemInventarioDTO dto);

    @Mapping(target = "residuo.id",     source = "residuo.id")
    @Mapping(target = "inventarioId",  source = "inventario.id")
    ItemInventarioDTO toDTO(ItemInventario entity);
}

