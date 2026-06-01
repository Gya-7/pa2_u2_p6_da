package ec.edu.uce;

import java.util.List;

import ec.edu.uce.application.service.ProfesorService;
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
            p1.setCarga_horaria(5);
            p1.setCorreo("carlos.mendoza@uce.edu.ec");

            this.profesorService.guardar(p1);

            // Profesor 2
            Profesor p2 = new Profesor();
            p2.setCedula("0923456781");
            p2.setNombre("Ana");
            p2.setApellido("Gómez");
            p2.setDepartamento("Sistemas");
            p2.setCarga_horaria(3);
            p2.setCorreo("ana.gomez@uce.edu.ec");

            this.profesorService.guardar(p2);

            // Profesor 3
            Profesor p3 = new Profesor();
            p3.setCedula("1104567892");
            p3.setNombre("Luis");
            p3.setApellido("Torres");
            p3.setDepartamento("Física");
            p3.setCarga_horaria(2);
            p3.setCorreo("luis.torres@uce.edu.ec");

            this.profesorService.guardar(p3);

            // Profesor 4
            Profesor p4 = new Profesor();
            p4.setCedula("1104567892");
            p4.setNombre("Carlos");
            p4.setApellido("Enriquez");
            p4.setDepartamento("Arte");
            p4.setCarga_horaria(7);
            p4.setCorreo("carlos.enrique@uce.edu.ec");

            this.profesorService.guardar(p4);

            // Profesor 5
            Profesor p5 = new Profesor();
            p5.setCedula("1234567890");
            p5.setNombre("Ana");
            p5.setApellido("Torres");
            p5.setDepartamento("Arte");
            p5.setCarga_horaria(10);
            p5.setCorreo("ana.torres@uce.edu.ec");

            this.profesorService.guardar(p5);

            //LISTA ORDENADA POR APELLIDO Y NOMBRE
            System.out.println("\nLISTA ORDENADA POR APELLIDO Y NOMBRE");
            List<Profesor> lista = this.profesorService.ordenarPorApellidoNombre();
            for(Profesor profesor : lista){
                System.out.println(profesor.toString());
            }

            //LISTA POR CARGA HORARIA

            System.out.println("\nLISTAR POR CARGA HORARIA");
            List<Profesor> lista2 = this.profesorService.consultarPorCargaHoraria(2, 5);
            for(Profesor profesor : lista2){
                System.out.println(profesor.toString());
            }

            //CONTAR POR DEPARTAMENTO
            System.out.println("\nCONTAR POR DEPARTAMENTO");
            String departamento = "Arte";
            Long valor = this.profesorService.contarPorDepartamento(departamento);
            System.out.println("Departamento: " + departamento + " - Cantidad de profesores: " + valor);

        

            return 0;

        }

    }
}
