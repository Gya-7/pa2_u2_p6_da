package ec.edu.uce;

import ec.edu.uce.application.service.GameCharacterService;
import ec.edu.uce.application.service.InventoryService;
import ec.edu.uce.domain.model.GameCharacter;
import ec.edu.uce.domain.model.Inventory;
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

        @Inject
        private InventoryService invService;

        @Override
        public int run(String... args) {

            
            GameCharacter gc = new GameCharacter();
            gc.setNickname("Milo");
            gc.setType("Mage");
            gc.setLevel(3);
            gc.setLifePoints(1400);

            Inventory inv = new Inventory();
            inv.setTotalSpace(6);
            inv.setOccupiedSpace(2);
            inv.setState("ACTIVO");
            inv.setCharacter(gc);

            this.invService.crear(inv);

            return 0;

        }

    }
}
