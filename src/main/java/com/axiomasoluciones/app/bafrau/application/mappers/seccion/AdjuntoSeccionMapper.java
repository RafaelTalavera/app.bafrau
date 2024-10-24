package com.axiomasoluciones.app.bafrau.application.mappers.seccion;

import com.axiomasoluciones.app.bafrau.application.dto.seccion.AdjuntoSeccionDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.seccion.AdjuntoSeccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdjuntoSeccionMapper {

    @Mapping(source = "seccion.id", target = "seccionId") // Mapear el ID de Seccion en lugar del objeto completo
    AdjuntoSeccionDTO toAdjuntoSeccionDTO(AdjuntoSeccion adjuntoSeccion);

    @Mapping(source = "seccionId", target = "seccion.id") // Mapear el ID de Seccion de vuelta al objeto Seccion
    AdjuntoSeccion toAdjuntoSeccion(AdjuntoSeccionDTO adjuntoSeccionDTO);
}
