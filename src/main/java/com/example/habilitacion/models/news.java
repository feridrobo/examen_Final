package com.example.habilitacion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "news")
@Data
@ToString
public class news {
    @Id
    @SequenceGenerator(name="news_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="news_id_seq")
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy="news")
    private List<categoriasnews> categorias;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "desarrollo")
    private String desarrollo;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "url")
    private String url;

    @Column(name = "resumen")
    private String resumen;

}
