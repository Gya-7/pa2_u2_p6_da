package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.GameCharacter;

public interface GameCharacterRepository {

    public void insertar(GameCharacter gc);
    public GameCharacter findById(Integer id);


}
