package com.axiomasoluciones.app.bafrau.application.mappers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ItemControlDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Documento;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.ItemControl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", imports = {Documento.class})
public interface ItemControlMapper {

    // DTO → Entidad (creación): ignorar id y control
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "control", ignore = true)
    @Mapping(source = "documentoId", target = "documento", qualifiedByName = "mapDocumentoId")
    @Mapping(source = "vencimiento", target = "vencimiento")
    @Mapping(source = "presentacion", target = "presentacion")
    @Mapping(source = "observaciones", target = "observaciones")
    @Mapping(source = "listMail", target = "listMail")
    ItemControl toEntity(ItemControlDTO dto);

    // Entidad → DTO (sin cambios)
    @Mapping(source = "id",                                 target = "id")
    @Mapping(source = "documento.id",                      target = "documentoId")
    @Mapping(source = "control.id",                        target = "controlId")
    @Mapping(source = "control.organizacion.razonSocial",  target = "razonSocial")
    @Mapping(source = "vencimiento",                       target = "vencimiento")
    @Mapping(source = "presentacion",                      target = "presentacion")
    @Mapping(source = "listMail",                          target = "listMail")
    @Mapping(source = "createdDate",                       target = "createdDate")
    @Mapping(source = "lastModifiedDate",                  target = "lastModifiedDate")
    @Mapping(source = "observaciones",                     target = "observaciones")
    @Mapping(source = "documento.nombre",                  target = "nombre")
    @Mapping(source = "documento.juridiccion",             target = "juridiccion")
    @Mapping(source = "documento.observaciones",           target = "observacionesDocumento")
    ItemControlDTO toDTO(ItemControl itemControl);

    @Named("mapDocumentoId")
    default Documento mapDocumentoId(Long id) {
        if (id == null) return null;
        Documento d = new Documento();
        d.setId(id);
        return d;
    }
}
