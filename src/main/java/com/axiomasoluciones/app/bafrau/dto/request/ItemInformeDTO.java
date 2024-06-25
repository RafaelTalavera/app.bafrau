package com.axiomasoluciones.app.bafrau.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemInformeDTO {
    private int magnitude;
    private int importance;
    private Long matrizId;
}