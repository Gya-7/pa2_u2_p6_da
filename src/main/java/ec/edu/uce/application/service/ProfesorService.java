package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesorService {

    @Inject
    private ProfesorRepository profesorRepository;

    public boolean guardar(Profesor profesor){

        try {

            this.profesorRepository.crear(profesor);
            System.out.println("Se ha guardado exitosamente");
            return true;
            
        } catch (Exception e) {
            System.out.println("No se pudo guardar");
            return false;
        }

    }

    public Profesor seleccionarPorId(Integer id){

        return this.profesorRepository.buscar(id);

    }

    public boolean actualizar(Integer id, Profesor profesor){

        Profesor profesorActualizado = this.seleccionarPorId(id);

        if(profesorActualizado == null){
            System.out.println("No  se encontro un profesor con ID: " + id);
            return false;
        }

        try {

            profesorActualizado.setNombre(profesor.getNombre());
            profesorActualizado.setApellido(profesor.getApellido());
            profesorActualizado.setDepartamento(profesor.getDepartamento());
            profesorActualizado.setCorreo(profesor.getCorreo());

            this.profesorRepository.actualizar(profesorActualizado);

            System.out.println("Se ha actualizado el profesor con ID: " + profesorActualizado.getId() + " y Apellido: " + profesorActualizado.getApellido());
            return true;
            
        } catch (Exception e) {
            
            System.out.println("No se pudo actuaizar el profesor con ID: " + id);

            return false;
        }

    }

    public boolean eliminar(Integer id){

        if(this.seleccionarPorId(id) == null){
            System.out.println("No  se encontro un profesor con ID: " + id);
            return false;
        }

        try {

            this.profesorRepository.eliminar(id);
            System.out.println("Se elimino el profesor con ID: " + id);
            return true;
            
        } catch (Exception e) {

            System.out.println("No se pudo eliminar el profesor con ID: " + id);
            return false;
            
        }
    }



}
