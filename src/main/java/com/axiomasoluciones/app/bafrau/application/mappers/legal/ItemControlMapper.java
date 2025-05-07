package com.axiomasoluciones.app.bafrau.application.mappers.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ItemControlDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Documento;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.ItemControl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring", imports = {Documento.class})
public interface ItemControlMapper {

    @Mapping(source = "id",                     target = "id")
    @Mapping(source = "documento.id",          target = "documentoId")
    @Mapping(source = "control.id",            target = "controlId")
    @Mapping(source = "vencimiento",           target = "vencimiento")
    @Mapping(source = "listMail",              target = "listMail")
    @Mapping(source = "observaciones",         target = "observaciones")             // ítem
    @Mapping(source = "documento.nombre",      target = "nombre")                    // doc.nombre
    @Mapping(source = "documento.juridiccion", target = "juridiccion")               // doc.juridiccion
    @Mapping(source = "documento.observaciones", target = "observacionesDocumento") // doc.observaciones
    ItemControlDTO toDTO(ItemControl itemControl);

    @Mapping(source = "controlId",     target = "control.id")
    @Mapping(source = "documentoId",   target = "documento", qualifiedByName = "mapDocumentoId")
    ItemControl toEntity(ItemControlDTO dto);

    @Named("mapDocumentoId")
    default Documento mapDocumentoId(Long id) {
        if (id == null) return null;
        Documento d = new Documento();
        d.setId(id);
        return d;
    }
}