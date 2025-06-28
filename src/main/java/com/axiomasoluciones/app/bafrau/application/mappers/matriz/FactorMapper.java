package com.axiomasoluciones.app.bafrau.application.mappers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.FactorDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Factor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FactorMapper {
    FactorDTO toFactorDTO(Factor factor);
    Factor toFactor(FactorDTO factorDTO);

    @Mapping(target = "id", ignore = true)
    void updateFromDto(FactorDTO dto, @MappingTarget Factor entity);
}

