package com.axiomasoluciones.app.bafrau.application.mappers.tabla;

import com.axiomasoluciones.app.bafrau.application.dto.tabla.FilaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.tabla.Fila;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CeldaMapper.class})
public interface FilaMapper {

    @Mapping(source = "tabla.id", target = "tablaId")
    FilaDTO toFilaDTO(Fila fila);

    @Mapping(source = "tablaId", target = "tabla.id")
    Fila toFila(FilaDTO filaDTO);
}
