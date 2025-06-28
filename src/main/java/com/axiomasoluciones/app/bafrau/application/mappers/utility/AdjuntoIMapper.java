package com.axiomasoluciones.app.bafrau.application.mappers.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdjuntoIMapper {

    AdjuntoIMapper INSTANCE = Mappers.getMapper(AdjuntoIMapper.class);

    @Mapping(source = "organizacion.id", target = "organizacionId")
    @Mapping(source = "seccion.id",      target = "seccionId")
    AdjuntoDTO toDto(Adjunto adjunto);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    @Mapping(source = "seccionId",      target = "seccion.id")
    Adjunto toEntity(AdjuntoDTO adjuntoDTO);
}
