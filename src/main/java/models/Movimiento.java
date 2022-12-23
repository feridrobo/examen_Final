package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Movimientos")
@ToString
@EqualsAndHashCode
public class Movimiento {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "fecha")
    private String apellido;

    @Getter @Setter @Column(name = "descripcion")
    private String email;

    @Getter @Setter @Column(name = "valor")
    private String telefono;


}

