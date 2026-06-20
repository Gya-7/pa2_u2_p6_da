package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AlumnoService {

    @Inject
    private AlumnoRepository ar;
    
    public void crear(Alumno alumno){

        this.ar.insert(alumno);

    }

    public Alumno seleccionarPorId(Integer id){

        return this.ar.findById(id);

    }
}
