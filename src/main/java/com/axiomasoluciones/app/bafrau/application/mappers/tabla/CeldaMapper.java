package com.axiomasoluciones.app.bafrau.application.mappers.tabla;

import com.axiomasoluciones.app.bafrau.application.dto.tabla.CeldaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.tabla.Celda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CeldaMapper {

    @Mapping(source = "columna.id", target = "columnaId")  // Mapeamos columna.id a columnaId
    @Mapping(source = "fila.id", target = "filaId")        // Mapeamos fila.id a filaId
    CeldaDTO toCeldaDTO(Celda celda);

    @Mapping(source = "columnaId", target = "columna.id")  // Mapeamos columnaId a columna.id
    @Mapping(source = "filaId", target = "fila.id")        // Mapeamos filaId a fila.id
    Celda toCelda(CeldaDTO celdaDTO);
}
