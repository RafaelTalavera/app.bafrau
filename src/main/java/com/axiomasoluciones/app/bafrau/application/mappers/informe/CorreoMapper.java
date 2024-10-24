package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CorreoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Correo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CorreoMapper {

    CorreoMapper INSTANCE = Mappers.getMapper(CorreoMapper.class);

    @Mapping(source = "informeId", target = "informe.id")
    Correo toEntity(CorreoDTO correoDTO);

    @Mapping(source = "informe.id", target = "informeId")
    CorreoDTO toDto(Correo correo);
}
