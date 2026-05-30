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
            e.setFechaNacimiento(LocalDate.of(2001, 07, 28));
            e.setGenero("F");

            this.estudianteService.guardar(e);

            Estudiante e1 = new Estudiante();
            e1.setNombre("Gyannelina");
            e1.setApellido("Cañas");
            e1.setCedula("0602366021");
            e1.setFechaNacimiento(LocalDate.of(2001, 07, 28));
            e1.setGenero("F");

            this.estudianteService.guardar(e1);


            Estudiante e2 = new Estudiante();
            e2.setNombre("Carlos");
            e2.setApellido("Bodoque");
            e2.setCedula("1719486523");
            e2.setFechaNacimiento(LocalDate.of(19911, 05, 13));
            e2.setGenero("M");

            this.estudianteService.guardar(e2);

            //TYPED
            System.out.println("\nTYPED");
            List<Estudiante> eTyped = this.estudianteService.consultarPorGeneroTyped("M");
            for(Estudiante estudiante: eTyped){

                System.out.println(estudiante.toString());

            }


            System.out.println("\nNO TYPED");
            List<Estudiante> eNamed = this.estudianteService.consultarPorGenero("F");
            for(Estudiante estudiante: eNamed){

                System.out.println(estudiante.toString());

            }

            LocalDate inicio = LocalDate.of(2000, 01, 01);
            LocalDate fin = LocalDate.of(2020, 01, 01);

            System.out.println("\nCONSULTA POR RANGO FECHA");
            List<Estudiante> listaFecha = this.estudianteService.consultarPorRangoFecha(inicio, fin);
            for (Estudiante estudiante : listaFecha) {

                System.out.println(estudiante.toString());

            }


            System.out.println("\nCONTAR ESTUDIANTES");
            Long value = this.estudianteService.contarEstudiantes();
            System.out.println(value);

        

            return 0;

        }

    }
}
