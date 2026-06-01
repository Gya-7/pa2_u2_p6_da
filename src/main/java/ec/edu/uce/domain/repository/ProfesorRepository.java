package ec.edu.uce.domain.repository;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {

    public void crear(Profesor profesor);

    public Profesor buscar(Integer id);

    public void actualizar(Profesor profesor);

    public void eliminar(Integer id);

    public List <Profesor> seleccionarTodos();

    public List <Profesor> seleccionarPorNombre(String nombre);

    public Profesor seleccionarPorCedula(String cedula);
    
    public List<Profesor> ordenPorApellidoNombre();

    public List <Profesor> seleccionarPorCargaHoraria(Integer min, Integer max);

    public Long contarPorDepartamento(String departamento);


}
