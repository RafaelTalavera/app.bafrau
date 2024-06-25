package com.axiomasoluciones.app.bafrau.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items_informes")
@Entity
public class ItemInforme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int magnitude;
    private int importance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="matriz_id")
    private Matriz matriz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id")
    private Informe informe;

}
