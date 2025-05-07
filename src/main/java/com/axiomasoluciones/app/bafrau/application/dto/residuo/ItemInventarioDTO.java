package com.axiomasoluciones.app.bafrau.application.dto.residuo;

import java.io.Serializable;

public class ItemInventarioDTO implements Serializable {

    private Long id;
    private Long inventarioId;      // referencia al Inventario padre
    private ResiduoDTO residuo;

    public ItemInventarioDTO() { }

    public ItemInventarioDTO(Long id, Long inventarioId, ResiduoDTO residuo) {
        this.id = id;
        this.inventarioId = inventarioId;
        this.residuo = residuo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Long inventarioId) {
        this.inventarioId = inventarioId;
    }

    public ResiduoDTO getResiduo() {
        return residuo;
    }

    public void setResiduo(ResiduoDTO residuo) {
        this.residuo = residuo;
    }
}
