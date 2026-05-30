package ec.edu.uce.domain.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {

    public void create(Estudiante estudiante);

    public Estudiante seleccionarPorId(Integer id);

    public void actualizar(Estudiante estudiante);

    public void eliminar(Integer id);

    public List<Estudiante> seleccionarTodos();

    public List<Estudiante> seleccionarPorNombre(String nombre);

    public Estudiante seleccionarPorCedula(String cedula);

    public List<Estudiante> seleccionarPorGenero(String genero);

    public List<Estudiante> seleccionarPorGeneroTyped(String genero);

    public List<Estudiante> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin);

    //lo comun es usar long
    public Long seleccionarContar();

    public List<Estudiante> seleccionarTodosNative();


}
