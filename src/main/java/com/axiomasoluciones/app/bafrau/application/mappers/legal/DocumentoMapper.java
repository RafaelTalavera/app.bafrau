package com.axiomasoluciones.app.bafrau.application.mappers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.DocumentoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Documento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);

    DocumentoDTO toDTO(Documento documento);

    Documento toEntity(DocumentoDTO documentoDTO);
}

