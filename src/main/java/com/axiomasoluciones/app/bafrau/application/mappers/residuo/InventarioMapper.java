package com.axiomasoluciones.app.bafrau.application.mappers.residuo;


import com.axiomasoluciones.app.bafrau.application.dto.residuo.InventarioDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.residuo.Inventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",
        uses = { ItemInventarioMapper.class })
public interface InventarioMapper {

    @Mapping(target = "organizacion.id", source = "organizacionId")
    @Mapping(target = "items",         source = "items")
    Inventario toEntity(InventarioDTO dto);

    @Mapping(target = "organizacionId", source = "organizacion.id")
    @Mapping(target = "items",          source = "items")
    InventarioDTO toDTO(Inventario entity);
}

