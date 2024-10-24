package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.AdjuntoInformeDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.AdjuntoInforme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdjuntoInformeMapper {

    AdjuntoInformeMapper INSTANCE = Mappers.getMapper(AdjuntoInformeMapper.class);

    @Mapping(source = "informe.id", target = "informeId")
    AdjuntoInformeDTO toDto(AdjuntoInforme adjuntoInforme);

    @Mapping(source = "informeId", target = "informe.id")
    AdjuntoInforme toEntity(AdjuntoInformeDTO adjuntoInformeDTO);
}