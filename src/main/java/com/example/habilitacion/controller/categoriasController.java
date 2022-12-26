package com.example.habilitacion.controller;


import com.example.habilitacion.dao.CategoriasDao;
import com.example.habilitacion.models.categoriasnews;
import com.example.habilitacion.models.news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class categoriasController {
    @Autowired
    private CategoriasDao categoriasDao;

    @GetMapping
    public List<news> getAllCategorias() {
        return categoriasDao.getCategorias();
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable int id) {
        categoriasDao.eliminar(id);
    }

    @PostMapping
    public void saveCategoria(@RequestBody categoriasnews categoria) {
        categoriasDao.guardar(categoria);
    }

    @PutMapping("/{id}")
    public void updateCategoria(@PathVariable int id, @RequestBody categoriasnews categoria) {
        categoria.setId(id);
        categoriasDao.guardar(categoria);
    }

    @GetMapping("/{id}")
    public categoriasnews getCategoriaById(@PathVariable int id) {
        return categoriasDao.listarId(id);
    }
}
