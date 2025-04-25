package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.TelefonoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Telefono;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TelefonoMapper {

    @Mapping(source = "organizacionId", target = "organizacion.id")
    Telefono toEntity(TelefonoDTO telefonoDTO);

    @Mapping(source = "organizacion.id", target = "organizacionId")
    TelefonoDTO toDto(Telefono telefono);
}
