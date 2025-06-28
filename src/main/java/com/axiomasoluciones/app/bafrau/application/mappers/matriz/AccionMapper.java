package com.axiomasoluciones.app.bafrau.application.mappers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.AccionDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Accion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccionMapper {
    AccionDTO toAccionDTO(Accion accion);
    Accion toAccion(AccionDTO accionDTO);
}
