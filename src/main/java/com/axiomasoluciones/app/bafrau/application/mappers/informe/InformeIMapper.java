package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        uses = {CapituloIMapper.class}  // mapea List<Capitulo> ↔ List<CapituloDTO>
)
public interface InformeIMapper {

    InformeIMapper INSTANCE = Mappers.getMapper(InformeIMapper.class);

    @Mapping(source = "organizacion.id", target = "organizacionId")
    InformeDTO toDto(Informe informe);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    Informe toEntity(InformeDTO dto);
}
