package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.TablaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Tabla;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FilaMapper.class)
public interface TablaMapper {
    @Mapping(source = "seccion.id", target = "seccionId")
    @Mapping(target = "filas", source = "filas")
    TablaDTO toDto(Tabla tabla);
    Tabla toEntity(TablaDTO dto);
}
