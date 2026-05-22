package ec.edu.uce;

import java.time.LocalDate;

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

            /* 
            Estudiante e = new Estudiante();
            e.setNombre("Dayerlin");
            e.setApellido("Aguilar");
            e.setFechaNacimiento(LocalDate.of(2001, 07, 28));
            e.setGenero("F");
            
            this.estudianteService.guardar(e);
            System.out.println("Seleccionado: " + this.estudianteService.seleccionarPorId(1).getNombre());

            Estudiante ea = new Estudiante();
            ea.setNombre("Gyannelina");
            ea.setApellido("Cañas");
            ea.setFechaNacimiento(LocalDate.of(2001, 07, 28));
            ea.setGenero("F");

            this.estudianteService.guardar(ea);

            ea.setNombre("Gyannela");
            this.estudianteService.actualizar(2, ea);
            System.out.println("Seleccionado: " + this.estudianteService.seleccionarPorId(2).getNombre());

            this.estudianteService.borrar(1);

            */

            Profesor p = new Profesor();
            p.setNombre("Dayerlin");
            p.setApellido("Aguilar");
            p.setDepartamento("Computacion");
            p.setCorreo("dgaguilar@uce.edu.ec");

            this.profesorService.guardar(p);
            System.out.println("Profesor " + p.getApellido() + " con ID: " + p.getId());
            System.out.println("--------------------------------------------------------------------------------------");

            Profesor profesorEncontrado = this.profesorService.seleccionarPorId(1);
            if (profesorEncontrado != null) {
                System.out.println("Se seleccionó el profesor con id -> " + profesorEncontrado.getId() + " y Apellido: " + profesorEncontrado.getApellido());

            } else {
                System.out.println("Aviso: No se encontró ningún profesor con el ID 1.");
            }
            
            System.out.println("--------------------------------------------------------------------------------------");
            p.setApellido("Canias");
            this.profesorService.actualizar(1, p);

            System.out.println("--------------------------------------------------------------------------------------");
            this.profesorService.eliminar(1);
            System.out.println("Seleccionado -> " + this.profesorService.seleccionarPorId(1));


            return 0;

        }

    }
}
