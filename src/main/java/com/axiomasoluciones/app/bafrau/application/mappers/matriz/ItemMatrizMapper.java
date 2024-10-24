package com.axiomasoluciones.app.bafrau.application.mappers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.ItemMatrizDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.ItemMatriz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {AccionMapper.class, FactorMapper.class})
public interface ItemMatrizMapper {

    @Mappings({
            @Mapping(source = "accion.id", target = "accionId"),
            @Mapping(source = "factor.id", target = "factorId")
    })
    ItemMatrizDTO toItemMatrizDTO(ItemMatriz itemMatriz);

    @Mappings({
            @Mapping(source = "accionId", target = "accion.id"),
            @Mapping(source = "factorId", target = "factor.id")
    })
    ItemMatriz toItemMatriz(ItemMatrizDTO itemMatrizDTO);
}
