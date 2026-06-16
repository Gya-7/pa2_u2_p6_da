package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
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
        private CiudadanoService ciudadanoService;

        @Inject 
        private EmpleadoService  empleadoService;

        @Override
        public int run(String... args) {

            /* 
            
            Ciudadano c = new Ciudadano();

            c.setNombre("Alejandro");
            c.setFechaNacimiento(LocalDateTime.of(1992, 03, 25, 07, 26));
            
            //this.ciudadanoService.insertarCiudadano(c);
            
            Empleado e = new Empleado();

            e.setCiudadano(c);
            e.setFechaIngreso(LocalDateTime.now());
            e.setSalario(12300.0);
            
            this.empleadoService.crear(e);

            */

            //crear un nuevo ciudadano con su propio service y ese mismo seteenle para crear un nuevo empleado con su propio service 

            
            Ciudadano c = new Ciudadano();
            c.setNombre("NUEVO TRANSACCION");
            c.setFechaNacimiento(LocalDateTime.of(2000, 05, 25, 0, 0));
            // this.ciudadanoService.insertarCiudadano(c1);
            
            //c1.setNombre("Carlos");

            Empleado e = new Empleado();
            e.setCiudadano(c);
            e.setFechaIngreso(LocalDateTime.of(1888, 8, 8, 8, 8));
            e.setSalario(null);

            this.empleadoService.crear(e);
            
            return 0;

        }

    }
}
