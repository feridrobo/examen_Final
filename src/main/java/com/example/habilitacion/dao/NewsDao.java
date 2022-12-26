package com.example.habilitacion.dao;

import com.example.habilitacion.models.news;

import java.util.List;

public interface NewsDao {


        List<news> getNews();

        void eliminar(int id);

        void guardar(news detalle);

        news listarId(int id);



}
