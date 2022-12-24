package controllers;

import dao.MovimientosDao;
import models.Movimiento;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
    @Autowired
    private MovimientosDao movimientosDao;

    @GetMapping
    public List<Movimiento> lista(){
        return movimientosDao.getMovimientos();
    }
    @GetMapping("/{id}")
    public Movimiento getById(@PathVariable long id) {
        return movimientosDao.listarId(id);
    }


    @PostMapping
    public Movimiento save(@RequestBody Movimiento movimiento) {
        movimientosDao.guardar(movimiento);
        return movimiento;
    }
    @DeleteMapping("/{id}")
    public Movimiento delete(@PathVariable long id) {
        Movimiento movimiento = movimientosDao.listarId(id);
        if (movimiento != null) {
            movimientosDao.eliminar(id);
            return movimiento;
        }
        return null;
    }
}
