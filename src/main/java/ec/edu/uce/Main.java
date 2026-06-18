package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Pedido;
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
        private ClienteService clienteService;

        @Override
        public int run(String... args) {

            System.out.println("Inicio Programa");

            Cliente c = new Cliente();
            c.setNombre("Dayerlin");
            c.setCedula("1719758690");

            Pedido p1 = new Pedido();
            p1.setTotal(10.0);
            p1.setCliente(c);
            p1.setFecha(LocalDate.of(2026, 10, 10));

            Pedido p2 = new Pedido();
            p2.setTotal(100.0);
            p2.setCliente(c);
            p2.setFecha(LocalDate.of(2026, 1, 5));

            List<Pedido> pedidos = new ArrayList<>();
            pedidos.add(p1);
            pedidos.add(p2);

            c.setPedidos(pedidos);

            this.clienteService.crear(c);

       

            return 0;
            
            
        }

    }
}
