package com.example.habilitacion.controller;


import com.example.habilitacion.dao.NewsDao;
import com.example.habilitacion.models.news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class newsController {
    @Autowired
    private NewsDao newsDao;

    @GetMapping
    public List<news> getAllNews() {
        return newsDao.getNews();
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable int id) {
        newsDao.eliminar(id);
    }

    @PostMapping
    public void saveNews(@RequestBody news detalle) {
        newsDao.guardar(detalle);
    }

    @PutMapping("/{id}")
    public void updateNews(@PathVariable int id, @RequestBody news detalle) {
        detalle.setId(id);
        newsDao.guardar(detalle);
    }

    @GetMapping("/{id}")
    public news getNewsById(@PathVariable int id) {
        return newsDao.listarId(id);
    }
}
