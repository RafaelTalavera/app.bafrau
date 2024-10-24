package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.TelefonoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Telefono;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TelefonoMapper {

    @Mapping(source = "informeId", target = "informe.id")
    Telefono toEntity(TelefonoDTO telefonoDTO);

    @Mapping(source = "informe.id", target = "informeId")
    TelefonoDTO toDto(Telefono telefono);
}
