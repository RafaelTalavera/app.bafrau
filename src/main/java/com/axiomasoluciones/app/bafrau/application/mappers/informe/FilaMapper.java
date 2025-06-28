package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.FilaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Fila;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CeldaMapper.class)
public interface FilaMapper {
    @Mapping(source = "tabla.id", target = "tablaId")
    FilaDTO toDto(Fila fila);
    Fila toEntity(FilaDTO dto);
}
