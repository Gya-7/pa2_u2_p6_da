package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

    //1. QUERY

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

        return miQuery.getResultList().getFirst();
    }

    @Override
    public List<Estudiante> seleccionarPorGeneroTyped(String genero) {

        TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);

        myQuery.setParameter("genero", genero);

        return myQuery.getResultList();

    }


    //QUERY

    @Override
    public List<Estudiante> seleccionarPorGenero(String genero) {
        
        Query myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero");

        myQuery.setParameter("genero", genero);

        return myQuery.getResultList();

    }

    @Override
    public List<Estudiante> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        
        TypedQuery <Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorRangoFecha", Estudiante.class);
        myQuery.setParameter("inicio", fechaInicio);
        myQuery.setParameter("fin", fechaFin);

        return myQuery.getResultList();


    }

    @Override
    public Long seleccionarContar() {
        
        TypedQuery<Long> myQuery = this.em.createNamedQuery("Estudiante.contar", Long.class);

        return myQuery.getSingleResult();



    }

    //2. NATIVE QUERY

    @Override
    @SuppressWarnings("unchecked")
    public List<Estudiante> seleccionarTodosNative() {

        Query myQuery  = this.em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);

        return myQuery.getResultList();

    }
    
    //3. CRITERIA API QUERY

    @Override
    public List<Estudiante> seleccionarTodosCriteria() {
        
        //crear una instancia de la clase que va a ser la encargada de la contruccion
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        //Definir el tipo de objeto que va a retornar mi consulta
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        //Se define las entidades del FROM
        Root<Estudiante> root = myQuery.from(Estudiante.class);
        //Se define con que tipo de sql se va a trabajar
        myQuery.select(root); // ESTA QUERY HACE UN SELECT AL FROM DE ROOT
        //Hasta aqui se termina de construir el Query

        //Transformar el builder de query a un query ejecutale -> SIEMPRE se hace
        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

    @Override
    public List<Estudiante> seleccionarPorNombreCriteria(String nombre) {
       
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);

        //WHERE e.apellido = 'Aguilar'
        //Los predicados se contruyen a partir del contructor
        //equual parametros -> Primero que se va a comparar(atributo de clase), contra que se va a comparar

        Predicate p1 = cb.equal(root.get("nombre"), nombre);
        //Las condiciones que se ponen en el where son predicados
        myQuery.select(root).where(p1);
        
        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

    @Override
    public List<Estudiante> seleccionarDinamicoCriteria(String nombre, String apellido) {
        
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);

        List<Predicate> condiciones = new ArrayList<>();

        if(nombre != null){
            Predicate p1 = cb.equal(root.get("nombre"), nombre);
            condiciones.add(p1);
        }

        if (apellido != null) {
            Predicate p2 = cb.equal(root.get("apellido"), apellido);
            condiciones.add(p2);
        }

        //Si ambos son null, entonces la lista no tiene condiciones, entonces no se entra al where
        myQuery.select(root).where(condiciones);

        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();



    }

    



    
}
