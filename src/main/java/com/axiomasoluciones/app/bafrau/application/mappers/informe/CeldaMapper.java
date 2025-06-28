package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CeldaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Celda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CeldaMapper {
    CeldaDTO toDto(Celda celda);
    Celda toEntity(CeldaDTO dto);
}
