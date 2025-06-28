package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.SeccionDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.AdjuntoIMapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {AdjuntoIMapper.class}
)
public interface SeccionIMapper {

    SeccionIMapper INSTANCE = Mappers.getMapper(SeccionIMapper.class);

    @Mapping(source = "capitulo.id",      target = "capituloId")
    @Mapping(source = "organizacion.id",  target = "organizacionId")
    @Mapping(source = "organizacion.razonSocial",target = "razonSocial")
    @Mapping(source = "styleTemplate.id", target = "styleTemplateId")
    @Mapping(source = "styleTemplate.nombre", target = "styleTemplateNombre")
    @Mapping(source = "adjuntos",         target = "adjuntos")       // mapea List<Adjunto> → List<AdjuntoDTO>
    @Mapping(source = "adjuntos",         target = "adjuntosIds", qualifiedByName = "toIds")
    SeccionDTO toDto(Seccion seccion);

    @Named("toIds")
    default List<Long> mapAdjuntosAIds(List<Adjunto> adjuntos) {
        return adjuntos == null
                ? List.of()
                : adjuntos.stream()
                .map(Adjunto::getId)
                .toList();
    }

    @Mapping(source = "capituloId",       target = "capitulo.id")
    @Mapping(source = "organizacionId",  target = "organizacion.id")
    @Mapping(source = "styleTemplateId",  target = "styleTemplate.id")


    @Mapping(target = "adjuntos",         ignore = true)  // lo manejás manualmente en el service
    Seccion toEntity(SeccionDTO dto);
}
