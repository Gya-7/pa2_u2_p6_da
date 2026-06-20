package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Alumno;

public interface AlumnoRepository {

    public void insert(Alumno alumno);
    public Alumno findById(Integer id);

}
