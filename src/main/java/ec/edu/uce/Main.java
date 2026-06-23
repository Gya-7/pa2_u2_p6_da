package ec.edu.uce;

import java.math.BigDecimal;

import ec.edu.uce.application.service.CuentaService;
import ec.edu.uce.application.service.TransferenciaService;
import ec.edu.uce.domain.model.Cuenta;
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
            this.cs.crear(cb1);

            ts.realizarTransferencia("343434343", "3462377", new BigDecimal(50));

    

            return 0;

        }

    }
}
