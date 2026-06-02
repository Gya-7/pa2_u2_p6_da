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
            e2.setFechaNacimiento(LocalDate.of(1911, 05, 13));
            e2.setGenero("M");

            this.estudianteService.guardar(e2);

            System.out.println("\nCRITERIA API QUERY");
            System.out.println("\nSeleccionar Todos");
            List<Estudiante> lista = this.estudianteService.seleccionarTodosCriteria();
            for(Estudiante estudiante: lista){

                System.out.println(estudiante.toString());

            }

            System.out.println("\nSeleccionarPorNombre");
            List<Estudiante> lista1 = this.estudianteService.seleccionarPorNombreCriteria("Carlos");
            for (Estudiante estudiante : lista1) {

                System.out.println(estudiante.toString());

            }

            System.out.println("\nSeleccionar DINAMICO - NO APELLIDO");
            List<Estudiante> lista2 = this.estudianteService.seleccionarDinamicoCriteria("Carlos", null);
            for (Estudiante estudiante : lista2) {

                System.out.println(estudiante.toString());

            }

            System.out.println("\nSeleccionar DINAMICO - NO NOMBRE");
            List<Estudiante> lista3 = this.estudianteService.seleccionarDinamicoCriteria(null, "Bodoque");
            for (Estudiante estudiante : lista3) {

                System.out.println(estudiante.toString());

            }

            System.out.println("\nSeleccionar DINAMICO - NADA");
            List<Estudiante> lista4 = this.estudianteService.seleccionarDinamicoCriteria(null, null);
            for (Estudiante estudiante : lista4) {

                System.out.println(estudiante.toString());

            }

            System.out.println("\nSeleccionar DINAMICO - AMBOS");
            List<Estudiante> lista5 = this.estudianteService.seleccionarDinamicoCriteria("Carlos", "Bodoque");
            for (Estudiante estudiante : lista5) {

                System.out.println(estudiante.toString());

            }



            return 0;

        }

    }
}
