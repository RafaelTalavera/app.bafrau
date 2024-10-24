package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ServicioDisponibleDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.ServicioDisponible;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicioDisponibleMapper {

    @Mapping(source = "informeId", target = "informe.id")
    ServicioDisponible toEntity(ServicioDisponibleDTO servicioDisponibleDTO);

    @Mapping(source = "informe.id", target = "informeId")
    ServicioDisponibleDTO toDto(ServicioDisponible servicioDisponible);
}
