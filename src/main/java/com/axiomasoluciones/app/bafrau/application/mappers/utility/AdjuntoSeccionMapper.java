package com.axiomasoluciones.app.bafrau.application.mappers.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdjuntoSeccionMapper {
    AdjuntoSeccionMapper INSTANCE = Mappers.getMapper(AdjuntoSeccionMapper.class);

    // Solo de entidad a DTO (puede tener ambos campos)
    @Mapping(source = "organizacion.id", target = "organizacionId")
    @Mapping(source = "seccion.id",      target = "seccionId")
    AdjuntoDTO toDto(Adjunto adjunto);

    // De DTO a entidad, **ignoro** la organización
    @Mapping(source = "seccionId", target = "seccion.id")
    @Mapping(target = "organizacion", ignore = true)
    Adjunto toEntity(AdjuntoDTO dto);
}
