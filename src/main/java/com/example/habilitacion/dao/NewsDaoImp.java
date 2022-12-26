package com.example.habilitacion.dao;

import com.example.habilitacion.models.news;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class NewsDaoImp implements NewsDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<news> getNews() {
        String query = "FROM news";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(int id) {
        news noticia = entityManager.find(news.class, id);
        entityManager.remove(noticia);
    }

    @Override
    public void guardar(news detalle) {
        entityManager.merge(detalle);
    }

    @Override
    public news listarId(int id) {
        String query = "FROM news m WHERE m.id = :id";
        return entityManager.createQuery(query, news.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
