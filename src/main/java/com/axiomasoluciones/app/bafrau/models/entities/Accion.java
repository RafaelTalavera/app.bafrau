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
@Table(name = "acciones")
@Entity
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clasificacion;
    private String tipo;

    public Accion(String clasificacion, String tipo){
        this.clasificacion = clasificacion;
        this.tipo = tipo;
    }
}
