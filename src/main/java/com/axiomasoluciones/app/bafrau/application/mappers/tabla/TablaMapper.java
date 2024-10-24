package com.axiomasoluciones.app.bafrau.application.mappers.tabla;

import com.axiomasoluciones.app.bafrau.application.dto.tabla.TablaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.tabla.Tabla;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ColumnaMapper.class})
public interface TablaMapper {

    @Mapping(source = "seccion.id", target = "seccionId")
    TablaDTO toTablaDTO(Tabla tabla);

    @Mapping(source = "seccionId", target = "seccion.id")
    Tabla toTabla(TablaDTO tablaDTO);
}
