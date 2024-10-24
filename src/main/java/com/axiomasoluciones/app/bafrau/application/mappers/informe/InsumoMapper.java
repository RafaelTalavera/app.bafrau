package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InsumoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Insumo;
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

