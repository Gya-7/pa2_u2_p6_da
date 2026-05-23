package ec.edu.uce;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Estudiante;
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
        private EstudianteService estudianteService;

 

        @Override
        public int run(String... args) {

            Estudiante e = new Estudiante();
            e.setNombre("Dayerlin");
            e.setApellido("Aguilar");
            e.setCedula("0602366021");
            e.setFechaNacimiento(LocalDate.of(2001, 07, 28));
            e.setGenero("F");
            
            this.estudianteService.guardar(e);
            //System.out.println("Seleccionado: " + this.estudianteService.seleccionarPorId(1).getNombre());

            Estudiante ea = new Estudiante();
            ea.setNombre("Gyannelina");
            ea.setApellido("Cañas");
            ea.setFechaNacimiento(LocalDate.of(2001, 07, 28));
            ea.setGenero("F");

            this.estudianteService.guardar(ea);

            ea.setNombre("Gyannela");
            this.estudianteService.actualizar(2, ea);
            System.out.println("Seleccionado: " + this.estudianteService.seleccionarPorId(2).getNombre());


            System.out.println("LISTA COMPLETA");


            List<Estudiante> lista = this.estudianteService.seleccionarTodos();

            for(Estudiante estudiante : lista){
                System.out.println(estudiante.toString());
            }

            System.out.println("LISTA POR NOMBRE");

            List<Estudiante> listaPorNombre = this.estudianteService.consultarPorNombre("Gyannela");

            for (Estudiante estu : listaPorNombre) {

                System.out.println(estu.toString());

            }

            System.out.println("ESTUDIANTE POR CEDULA");
            System.out.println(this.estudianteService.consultarPorCedula("0602366021"));

            return 0;

        }

    }
}
