package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import org.mapstruct.Mapper;
import com.axiomasoluciones.app.bafrau.application.dto.informe.CaratulaDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Caratula;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.AdjuntoIMapper;

@Mapper(componentModel = "spring", uses = {AdjuntoIMapper.class})
public interface CaratulaIMapper {

    Caratula toEntity(CaratulaDTO dto);

    CaratulaDTO toDto(Caratula entity);
}
