package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Mission;
import ec.edu.uce.domain.repository.MissionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MissionService {

    @Inject
    private MissionRepository mRepository;

    public void crear(Mission mission){

        this.mRepository.insert(mission);

    }

    public Mission seleccionarPorId(Integer id){

        return this.mRepository.findById(id);

    }

}
