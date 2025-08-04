package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.EncabezadoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Encabezado;
import com.axiomasoluciones.app.bafrau.application.mappers.utility.AdjuntoIMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {AdjuntoIMapper.class})
public interface EncabezadoMapper {

    @Mapping(source = "informe.id",       target = "informeId")
    @Mapping(source = "adjuntos",         target = "adjuntos")              // usa AdjuntoIMapper.toDto()
    @Mapping(source = "adjuntos",         target = "adjuntosIds", qualifiedByName = "adjuntosToIds")
    EncabezadoDTO toDto(Encabezado e);

    @Named("adjuntosToIds")
    default List<Long> adjuntosToIds(List<Adjunto> adjuntos) {
        if (adjuntos == null) return List.of();
        return adjuntos.stream()
                .map(Adjunto::getId)
                .collect(Collectors.toList());
    }

    @Mapping(source = "informeId",       target = "informe.id")
    Encabezado toEntity(EncabezadoDTO dto);
}
