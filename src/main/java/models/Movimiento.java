package models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Entity
@Table(name = "Movimientos")
@Data
@ToString
@EqualsAndHashCode
public class Movimiento {
    @Id
    @SequenceGenerator(name="bill_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bill_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Usuario usuario;

    @Column(name = "date_bill")
    private Date dateBill;

    @Column(name = "value")
    private int value;

    @Column(name = "type")
    private int type;

    @Column(name = "observation")
    private String observation;

}


