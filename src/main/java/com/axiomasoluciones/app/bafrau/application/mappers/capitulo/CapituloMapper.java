package com.axiomasoluciones.app.bafrau.application.mappers.capitulo;

import com.axiomasoluciones.app.bafrau.application.dto.capitulo.CapituloDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.InformeMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.capitulo.Capitulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {InformeMapper.class})
public interface CapituloMapper {
    CapituloDTO toCapituloDTO(Capitulo capitulo);
    Capitulo toCapitulo(CapituloDTO capituloDTO);
}
