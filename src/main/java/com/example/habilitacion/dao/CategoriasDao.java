package com.example.habilitacion.dao;

import com.example.habilitacion.models.categoriasnews;
import com.example.habilitacion.models.news;

import java.util.List;

public interface CategoriasDao {

    List<news> getCategorias();

    void eliminar(int id);

    void guardar(categoriasnews detalle);

    categoriasnews listarId(int id);


}
