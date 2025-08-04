package com.axiomasoluciones.app.bafrau.application.mappers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Control;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { ItemControlMapper.class })
public interface ControlMapper {

    ControlMapper INSTANCE = Mappers.getMapper(ControlMapper.class);

    // Entidad → DTO
    @Mapping(source = "organizacion.id",          target = "organizacionId")
    @Mapping(source = "organizacion.razonSocial", target = "organizacionRazonSocial")
    ControlDTO toDTO(Control control);

    // DTO → Entidad (creación): ignorar el id para que Hibernate lo genere
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "organizacionId", target = "organizacion", qualifiedByName = "mapOrganizacionFromId")
    Control toEntity(ControlDTO dto);

    @Named("mapOrganizacionFromId")
    default Organizacion mapOrganizacionFromId(Long id) {
        if (id == null) return null;
        Organizacion o = new Organizacion();
        o.setId(id);
        return o;
    }

    // Después de mapear padre y lista de items, establecemos la back-reference
    @AfterMapping
    default void linkItems(@MappingTarget Control control) {
        if (control.getItems() != null) {
            control.getItems().forEach(item -> item.setControl(control));
        }
    }

    // DTO → Entidad (edición): actualiza sólo campos no nulos, mantiene el id existente
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "organizacionId", target = "organizacion", qualifiedByName = "mapOrganizacionFromId")
    @Mapping(target = "items", ignore = true)
    void updateFromDto(ControlDTO dto, @MappingTarget Control control);
}
