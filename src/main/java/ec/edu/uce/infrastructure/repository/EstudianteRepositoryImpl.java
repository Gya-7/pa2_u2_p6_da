package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional // COmo esta clase esta destinada a conectarse a la base de datos debe haber una transaccion (Se explicada despues)
public class EstudianteRepositoryImpl implements EstudianteRepository {
                            
    @Inject
    private EntityManager em;
    //TODA CONEXION A LA BASE DE DATOS A TRAVES DEL ENTITY MANAGER

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

    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        //Clase generica que exige que se especifique el objeto con el cual se va a trabajar
        //Esto es todo lo que tiene que tener el query cuando no tiene parametros


        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorNombre(String nombre) {

        //Se pone nombre1 para que se entienda que no es el mismo nombre de la firma del metodo y se va a reemplazar por algo
        //LOS DOS PUNTOS SON IMPORTANTES PORQUE DICE QUE LO QUE VIENE DESPUES ES EL NOMBRE DE UNA VARIABLE
        TypedQuery <Estudiante> miQuery = this.em.createQuery(
            "SELECT e FROM Estudiante e WHERE e.nombre = :nombre1", Estudiante.class);
            //nombre del parametro puesto arriba, nombre de lo que quiero usar
            miQuery.setParameter("nombre1", nombre);
        
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
    
        //En el diamante va el tipo de objeto que va a retornar el objeto
        TypedQuery<Estudiante> miQuery = this.em.createQuery(
            "SELECT e FROM Estudiante e WHERE e.cedula = :cedula1", Estudiante.class);

            miQuery.setParameter("cedula1", cedula);

       return miQuery.getResultList().get(0);

        //return miQuery.getResultList().getFirst();
    }

    
}
