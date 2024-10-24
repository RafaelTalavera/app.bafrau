package com.axiomasoluciones.app.bafrau.application.mappers.tabla;

import com.axiomasoluciones.app.bafrau.application.dto.tabla.ColumnaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.tabla.Columna;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CeldaMapper.class})
public interface ColumnaMapper {

    @Mapping(source = "tabla.id", target = "tablaId")
    ColumnaDTO toColumnaDTO(Columna columna);

    @Mapping(source = "tablaId", target = "tabla.id")
    Columna toColumna(ColumnaDTO columnaDTO);
}
