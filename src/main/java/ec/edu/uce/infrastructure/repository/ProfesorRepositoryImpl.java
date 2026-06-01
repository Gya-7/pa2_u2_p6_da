package ec.edu.uce.infrastructure.repository;

import java.lang.reflect.Type;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    //NAMED QUERIES

    @Override
    public List<Profesor> ordenPorApellidoNombre() {
        
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.listarApellidoNombreAsc", Profesor.class);
        
        return myQuery.getResultList();

    }

    @Override
    public List<Profesor> seleccionarPorCargaHoraria(Integer min, Integer max) {
        
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.listarPorCargaHoraria", Profesor.class);
        
        myQuery.setParameter("min", min);
        myQuery.setParameter("max", max);

        return myQuery.getResultList();
    }

    @Override
    public Long contarPorDepartamento(String departamento) {
        
        TypedQuery<Long> myQuery = this.em.createNamedQuery("Profesor.contarPorDepartamento", Long.class);
        
        myQuery.setParameter("departamento", departamento);

        return myQuery.getSingleResult();
    }

    //NATIVE QUERIES

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarTodosNative() {
        
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
        
        return myQuery.getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarPorDepartamentoNative(String departamento) {
        
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_departamento = :departamento", Profesor.class);
        myQuery.setParameter("departamento", departamento);
        
        return myQuery.getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarProfesoresActivosNative() {
        
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_fecha_fin IS NULL", Profesor.class);
        
        return myQuery.getResultList();

    }

    @Override
    public Long promedioCargaHorariaNative() {
        
        Query myQuery = this.em.createNativeQuery("SELECT AVG(prof_carga_horaria) FROM profesor");
        
        return ((Number) myQuery.getSingleResult()).longValue();
    }

    

}
