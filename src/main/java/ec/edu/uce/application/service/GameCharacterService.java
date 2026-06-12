package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.GameCharacter;
import ec.edu.uce.domain.repository.GameCharacterRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GameCharacterService {

    @Inject
    private GameCharacterRepository gcRepository;

    public void create(GameCharacter gc){

        this.gcRepository.insertar(gc);

    }



}
