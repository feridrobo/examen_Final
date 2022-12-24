package dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import models.Movimiento;
import models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MovimientosDaoImp implements MovimientosDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Movimiento> getMovimientos() {
        String query = "FROM Movimiento";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Optional<Persona> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        Movimiento movimiento = entityManager.find(Movimiento.class, id);
        entityManager.remove(movimiento);
    }

    @Override
    public void guardar(Movimiento movimiento) {
        entityManager.merge(movimiento);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;
    }
}
