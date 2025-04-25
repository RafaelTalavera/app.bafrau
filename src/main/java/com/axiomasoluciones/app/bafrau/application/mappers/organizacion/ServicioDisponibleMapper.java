package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ServicioDisponibleDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.ServicioDisponible;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicioDisponibleMapper {

    @Mapping(source = "organizacionId", target = "organizacion.id")
    ServicioDisponible toEntity(ServicioDisponibleDTO servicioDisponibleDTO);

    @Mapping(source = "organizacion.id", target = "organizacionId")
    ServicioDisponibleDTO toDto(ServicioDisponible servicioDisponible);
}
