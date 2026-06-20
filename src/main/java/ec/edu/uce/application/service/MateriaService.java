package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MateriaService {

    @Inject
    private MateriaRepository mr;

    public void crear(Materia materia) {

        this.mr.insert(materia);

    }

    public Materia seleccionarPorId(Integer id) {

        return this.mr.findById(id);

    }

    //crar unaconsulta por id de materia
}
