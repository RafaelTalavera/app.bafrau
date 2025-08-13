package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo.CapituloDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Capitulo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        uses = {SeccionIMapper.class}  // para List<Seccion> ↔ List<SeccionDTO>
)
public interface CapituloIMapper {

    CapituloIMapper INSTANCE = Mappers.getMapper(CapituloIMapper.class);

    @Mapping(source = "informe.id", target = "informeId")
    CapituloDTO toDto(Capitulo capitulo);

    @Mapping(source = "informeId", target = "informe.id")
    Capitulo toEntity(CapituloDTO dto);
}
