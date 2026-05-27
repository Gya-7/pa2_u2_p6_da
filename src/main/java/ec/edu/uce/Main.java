package ec.edu.uce;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Profesor;
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

        /*
        @Inject
        private EstudianteService estudianteService;
        */

        @Inject
        private ProfesorService profesorService;

 

        @Override
        public int run(String... args) {

            System.err.println("GUARDAR PROFESORES");

            // Profesor 1
            Profesor p1 = new Profesor();
            p1.setCedula("1712345678");
            p1.setNombre("Carlos");
            p1.setApellido("Mendoza");
            p1.setDepartamento("Matemáticas");
            p1.setCorreo("carlos.mendoza@uce.edu.ec");

            this.profesorService.guardar(p1);

            // Profesor 2
            Profesor p2 = new Profesor();
            p2.setCedula("0923456781");
            p2.setNombre("Ana");
            p2.setApellido("Gómez");
            p2.setDepartamento("Sistemas");
            p2.setCorreo("ana.gomez@uce.edu.ec");

            this.profesorService.guardar(p2);

            // Profesor 3
            Profesor p3 = new Profesor();
            p3.setCedula("1104567892");
            p3.setNombre("Luis");
            p3.setApellido("Torres");
            p3.setDepartamento("Física");
            p3.setCorreo("luis.torres@uce.edu.ec");

            this.profesorService.guardar(p3);

            // Profesor 4
            Profesor p4 = new Profesor();
            p4.setCedula("1104567892");
            p4.setNombre("Carlos");
            p4.setApellido("Enriquez");
            p4.setDepartamento("Ingles");
            p4.setCorreo("carlos.enrique@uce.edu.ec");

            this.profesorService.guardar(p4);

            // Profesor 5
            Profesor p5 = new Profesor();
            p5.setCedula("1234567890");
            p5.setNombre("Ana");
            p5.setApellido("Torres");
            p5.setDepartamento("Arte");
            p5.setCorreo("ana.torres@uce.edu.ec");

            this.profesorService.guardar(p5);


            System.out.println("\nLISTA COMPLETA");
            List<Profesor> listaCompleta = this.profesorService.seleccionarTodos();
            for(Profesor profesor : listaCompleta){

                System.out.println(profesor.toString());

            }

            String name = "Ana";

            System.out.println("\nLISTA POR NOMBRE: " + name);
            List <Profesor> listaPorNombre = this.profesorService.consultarPorNombre(name);
            for(Profesor profesor : listaPorNombre){

                System.out.println(profesor.toString());

            }
            
            String cedula = "1104567892";
            
            System.out.println("\nLISTA POR CEDULA: " + cedula);
            Profesor consultaPorCedula = this.profesorService.consultarPorCedula(cedula);
            System.out.println(consultaPorCedula);
            


            return 0;

        }

    }
}
