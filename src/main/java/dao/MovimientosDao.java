package dao;

import models.Movimiento;
import models.Usuario;

import java.util.List;
import java.util.Optional;

public interface MovimientosDao {

    List<Movimiento> getMovimientos();

    void eliminar(Long id);

    void guardar(Movimiento movimiento);

     Optional<Movimiento> listarId(int id);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
