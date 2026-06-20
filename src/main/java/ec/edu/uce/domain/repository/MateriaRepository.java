package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Materia;

public interface MateriaRepository {

    public void insert(Materia materia);

    public Materia findById(Integer id);

}
