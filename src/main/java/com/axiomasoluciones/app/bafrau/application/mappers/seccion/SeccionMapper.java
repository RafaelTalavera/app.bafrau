package com.axiomasoluciones.app.bafrau.application.mappers.seccion;

import com.axiomasoluciones.app.bafrau.application.dto.seccion.SeccionDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.seccion.Seccion;
import com.axiomasoluciones.app.bafrau.application.mappers.matriz.MatrizMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.tabla.TablaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MatrizMapper.class, AdjuntoSeccionMapper.class})
public interface SeccionMapper {

    @Mapping(source = "capitulo.id", target = "capituloId")
    @Mapping(target = "tablas", ignore = true) // Ignoramos las tablas aquí
    SeccionDTO toSeccionDTO(Seccion seccion);

    @Mapping(source = "capituloId", target = "capitulo.id")
    @Mapping(target = "tablas", ignore = true)
    Seccion toSeccion(SeccionDTO seccionDTO);
}
