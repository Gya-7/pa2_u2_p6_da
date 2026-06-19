package ec.edu.uce;

import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.InventoryService;
import ec.edu.uce.domain.model.Inventory;
import ec.edu.uce.domain.model.Item;
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
        private InventoryService invService;

        @Override
        public int run(String... args) {

            Inventory in = new Inventory();
            in.setTotalSpace(10);
            in.setOccupiedSpace(2);
            in.setState("AVAILABLE");

            Item item = new Item();
            
            item.setNombre("Pocion de vida");
            item.setCantidad(3);
            item.setInventory(in);
            
            Item item2 = new Item();
            item2.setNombre("Espada curva");
            item2.setCantidad(3);
            item2.setInventory(in);

            List<Item> items = new ArrayList<>();
            items.add(item);
            items.add(item2);

            
            in.setItem(items);

            this.invService.crear(in);

            return 0;

        }

    }
}
