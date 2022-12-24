package controllers;

import dao.MovimientosDao;
import models.Movimiento;
import org.springframework.web.bind.annotation.*;

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
    public Movimiento getById(@PathVariable Integer id) {
        Optional<Movimiento> bill=movimientosDao.listarId(id);
        if(bill.isPresent()) {
            return bill.get();
        }
        return null;
    }

    @PostMapping
    public Movimiento save(@RequestBody Movimiento movimiento) {
        movimientosDao.guardar(movimiento);
        return movimiento;
    }
    @DeleteMapping("/{id}")
    public Movimiento delete(@PathVariable Integer id) {
        Optional<Movimiento> movimiento=movimientosDao.listarId(id);
        if(movimiento.isPresent()) {
            movimientosDao.eliminar(Long.valueOf(id));
            return movimiento.get();
        }
        return null;
    }
}
