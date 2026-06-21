package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.GameCharacter;
import ec.edu.uce.domain.repository.GameCharacterRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class GameCharacterRepositoryImpl implements GameCharacterRepository{

    @Inject
    private EntityManager em;

    @Override
    public void insertar(GameCharacter gc) {
        
        this.em.persist(gc);
    }

    @Override
    public GameCharacter findById(Integer id) {
        
        return this.em.find(GameCharacter.class, id);

    }



}
