package com.axiomasoluciones.app.bafrau.domain.services.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.application.dto.legal.ItemControlDTO;
import com.axiomasoluciones.app.bafrau.application.dto.organizacion.OrganizacionDTO;

import java.util.List;

public interface ControlService {

    ControlDTO crearControl(ControlDTO controlDTO);
    List<ControlDTO> obtenerTodos();
    ControlDTO obtenerPorId(Long id);
    void eliminarControl(Long id);
    void checkAndSendNotifications();
    ControlDTO editarControl(Long id, ControlDTO controlDTO);
    ItemControlDTO cambiarEstadoItem(Long itemId);
    List<OrganizacionDTO> obtenerOrganizacionesConItemsControl();
    List<ItemControlDTO> obtenerItemsPorOrganizacion(Long organizacionId);
}

