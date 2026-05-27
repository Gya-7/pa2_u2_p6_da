package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository{


    @Inject
    private EntityManager em;

    @Override
    public void crear(Profesor profesor) {
        
        this.em.persist(profesor);

    }

    @Override
    public Profesor buscar(Integer id) {
        
        return this.em.find(Profesor.class, id);

    }

    @Override
    public void actualizar(Profesor profesor) {
        
        this.em.merge(profesor);

    }

    @Override
    public void eliminar(Integer id) {
        
        this.em.remove(this.buscar(id));

    }

    @Override
    public List<Profesor> seleccionarTodos() {
       
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return miQuery.getResultList();

    }

    @Override
    public List<Profesor> seleccionarPorNombre(String nombre) {
        
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombre1", Profesor.class);
        miQuery.setParameter("nombre1", nombre);

        return miQuery.getResultList();

    }

    @Override
    public Profesor seleccionarPorCedula(String cedula) {
        
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula LIKE :cedula1", Profesor.class);
        miQuery.setParameter("cedula1", cedula);

        return miQuery.getResultList().getFirst();

    }

}
