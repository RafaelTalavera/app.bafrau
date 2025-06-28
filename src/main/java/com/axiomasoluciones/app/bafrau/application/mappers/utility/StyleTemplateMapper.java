package com.axiomasoluciones.app.bafrau.application.mappers.utility;

import com.axiomasoluciones.app.bafrau.application.dto.utility.StyleTemplateDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.StyleTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StyleTemplateMapper {

    StyleTemplateMapper INSTANCE = Mappers.getMapper(StyleTemplateMapper.class);

    StyleTemplateDTO toDto(StyleTemplate entity);

    StyleTemplate toEntity(StyleTemplateDTO dto);
}

