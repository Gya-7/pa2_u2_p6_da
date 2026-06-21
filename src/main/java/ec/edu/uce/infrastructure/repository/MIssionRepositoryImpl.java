package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Mission;
import ec.edu.uce.domain.repository.MissionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MIssionRepositoryImpl implements MissionRepository{

    @Inject
    private EntityManager em;

    @Override
    public void insert(Mission mission) {
        
        this.em.persist(mission);

    }

    @Override
    public Mission findById(Integer id) {
        
        return this.em.find(Mission.class, id);

    }

}
