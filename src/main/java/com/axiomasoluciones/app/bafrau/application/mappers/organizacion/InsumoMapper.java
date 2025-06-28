package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.InsumoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Insumo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InsumoMapper {

    @Mapping(source = "proceso.id", target = "procesoId")
    InsumoDTO toInsumoDTO(Insumo insumo);

    // No mapear procesoId a proceso.id aquí
    @Mapping(target = "proceso", ignore = true)
    Insumo toInsumo(InsumoDTO insumoDTO);
}

