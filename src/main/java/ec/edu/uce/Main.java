package ec.edu.uce;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.application.service.CuentaService;
import ec.edu.uce.application.service.TransferenciaService;
import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Transferencia;
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
        private CuentaService cs;
        
        @Inject
        private TransferenciaService ts;

        @Override
        public int run(String... args) {

            System.out.println("Inicio Programa");

            
            Cuenta cb1 = new Cuenta();
            cb1.setNombreTitular("Julia");
            cb1.setNumeroCuenta("343434343");
            cb1.setMonto(new BigDecimal(100));
            this.cs.crear(cb1);
       
            Cuenta cb2 = new Cuenta();
            cb2.setNombreTitular("Kevin");
            cb2.setNumeroCuenta("3462377");
            cb2.setMonto(new BigDecimal(50));
            this.cs.crear(cb2);

            ts.realizarTransferencia("343434343", "3462377", new BigDecimal(50));
            
            

            Cuenta cuenta1 = this.cs.seleccionarPorCuenta("343434343");

            List<Transferencia> listaRealizadas = cuenta1.getTransferenciasRealizadas();
 
            for (Transferencia trans : listaRealizadas) {

                System.out.println(trans.toString());
               
            }
    

            return 0;

        }

    }
}
