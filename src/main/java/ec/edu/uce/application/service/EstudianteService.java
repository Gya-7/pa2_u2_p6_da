package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    public void guardar(Estudiante estudiante){

        this.estudianteRepository.create(estudiante);

    }

    public Estudiante seleccionarPorId(Integer id){

        return this.estudianteRepository.seleccionarPorId(id);

    }

    public void actualizar (Integer id, Estudiante estudiante){

        
        Estudiante ea = this.seleccionarPorId(id);

        ea.setNombre(estudiante.getNombre());
        ea.setApellido(estudiante.getApellido());
        ea.setFechaNacimiento(estudiante.getFechaNacimiento());
        ea.setGenero(estudiante.getGenero());

        this.estudianteRepository.actualizar(ea);

    }

    public void borrar(Integer id){

        this.estudianteRepository.eliminar(id);
        System.out.println("Elimnado id: " + id);


    }

    public List<Estudiante> seleccionarTodos(){

       return  this.estudianteRepository.seleccionarTodos();

    }

    public List<Estudiante> consultarPorNombre(String nombre) {

        return this.estudianteRepository.seleccionarPorNombre(nombre);

    }

    public Estudiante consultarPorCedula(String cedula) {

        return this.estudianteRepository.seleccionarPorCedula(cedula); 

    }


}
