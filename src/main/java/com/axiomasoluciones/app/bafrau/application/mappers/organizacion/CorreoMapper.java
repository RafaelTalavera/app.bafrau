package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.CorreoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Correo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CorreoMapper {

    CorreoMapper INSTANCE = Mappers.getMapper(CorreoMapper.class);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    Correo toEntity(CorreoDTO correoDTO);

    @Mapping(source = "organizacion.id", target = "organizacionId")
    CorreoDTO toDto(Correo correo);
}
