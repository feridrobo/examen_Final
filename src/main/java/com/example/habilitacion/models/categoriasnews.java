package com.example.habilitacion.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "categoriasnews")
@ToString
@EqualsAndHashCode
public class categoriasnews {


    @Getter
    @Setter
    @Column(name = "")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;



    @ManyToOne
    @JoinColumn(name="categoriasnews_id")
    private categoriasnews categoria;

}
