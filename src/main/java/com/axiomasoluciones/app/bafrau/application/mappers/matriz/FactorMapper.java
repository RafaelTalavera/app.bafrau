package com.axiomasoluciones.app.bafrau.application.mappers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.FactorDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Factor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FactorMapper {
    FactorDTO toFactorDTO(Factor factor);
    Factor toFactor(FactorDTO factorDTO);
}

