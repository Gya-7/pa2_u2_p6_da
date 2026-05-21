package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Estudiante;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional // COmo esta clase esta destinada a conectarse a la base de datos debe haber una transaccion (Se explicada despues)
public class EstudianteRepositoryImpl implements ec.edu.uce.domain.repository.EstudianteRepository {
                            
    @Inject
    private EntityManager em;

    @Override
    public void create(Estudiante estudiante) {

        this.em.persist(estudiante);
    }

    @Override
    public Estudiante seleccionarPorId(Integer id) {

        return this.em.find(Estudiante.class, id);

    }

    @Override
    public void actualizar(Estudiante estudiante) {

        this.em.merge(estudiante);

    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id));
        {

        }

    }
}
