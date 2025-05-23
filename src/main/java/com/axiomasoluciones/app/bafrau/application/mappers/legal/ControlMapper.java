// src/main/java/com/axiomasoluciones/app/bafrau/application/mappers/legal/ControlMapper.java
package com.axiomasoluciones.app.bafrau.application.mappers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Control;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { ItemControlMapper.class })
public interface ControlMapper {

    ControlMapper INSTANCE = Mappers.getMapper(ControlMapper.class);

    @Mapping(source = "organizacion.id",           target = "organizacionId")
    @Mapping(source = "organizacion.razonSocial",  target = "organizacionRazonSocial")
    ControlDTO toDTO(Control control);

    @Mapping(source = "organizacionId", target = "organizacion", qualifiedByName = "mapOrganizacionFromId")
    Control toEntity(ControlDTO dto);

    @Named("mapOrganizacionFromId")
    default Organizacion mapOrganizacionFromId(Long id) {
        if (id == null) return null;
        Organizacion o = new Organizacion();
        o.setId(id);
        return o;
    }

    @AfterMapping
    default void linkItems(@MappingTarget Control control) {
        control.getItems().forEach(i -> i.setControl(control));
    }

    /**
     * Actualiza una entidad Control existente con los valores no nulos del DTO.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "organizacionId", target = "organizacion", qualifiedByName = "mapOrganizacionFromId")
    void updateFromDto(ControlDTO dto, @MappingTarget Control control);
}
