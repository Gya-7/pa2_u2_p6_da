package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.GameCharacterService;
import ec.edu.uce.domain.model.GameCharacter;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
  
   
    }

    public static class App implements QuarkusApplication {


        @Inject
        private GameCharacterService gcService;

        @Override
        public int run(String... args) {

            GameCharacter gc = new GameCharacter();
            gc.setLevel(1);
            gc.setNickname("Houston");
            gc.setType("Assassin");
            gc.setLifePoints(100);


            this.gcService.create(gc);

            

            return 0;

        }

    }
}
