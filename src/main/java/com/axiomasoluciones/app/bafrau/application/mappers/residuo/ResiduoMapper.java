package com.axiomasoluciones.app.bafrau.application.mappers.residuo;

import com.axiomasoluciones.app.bafrau.application.dto.residuo.ResiduoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.residuo.Residuo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResiduoMapper {

    ResiduoMapper INSTANCE = Mappers.getMapper(ResiduoMapper.class);

    ResiduoDTO toDTO(Residuo residuo);

    Residuo toEntity(ResiduoDTO residuoDTO);
}
