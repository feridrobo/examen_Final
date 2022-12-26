package com.example.habilitacion.dao;

import com.example.habilitacion.models.categoriasnews;
import com.example.habilitacion.models.news;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CategoriasDaoImp implements CategoriasDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<news> getCategorias() {
        String query = "FROM categoriasNews";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(int id) {
        categoriasnews categoria = entityManager.find(categoriasnews.class, id);
        entityManager.remove(categoria);
    }

    @Override
    public void guardar(categoriasnews categoria) {
        entityManager.merge(categoria);
    }

    @Override
    public categoriasnews listarId(int id) {
        return null;
    }
}
