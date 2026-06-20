package ec.edu.uce;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.MateriaService;
import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Materia;
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
        private AlumnoService alumnoService;

        @Inject
        private MateriaService materiaService;

        @Override
        public int run(String... args) {

            System.out.println("Inicio Programa");

            //Alumno que tomo dos materia

            /*

            Alumno a1 = new Alumno();
            a1.setNombre("Dayerlin");

            Materia m1 = new Materia();
            m1.setNombre("P. Avanzada");
            m1.setNumeroCreditos(4);

            Materia m2 = new Materia();
            m2.setNombre("P. web");
            m2.setNumeroCreditos(6);

            List<Materia> listaMaterias = List.of(m1, m2);

            a1.setMaterias(listaMaterias);

            this.alumnoService.crear(a1);

            
 
            Materia m3 = new Materia();
            m3.setNombre("P. Distribuida");
            m3.setNumeroCreditos(8);

            Alumno a2 = new Alumno();
            a2.setNombre("Mateo");
            a2.setMaterias(List.of(m3));

            Alumno a3 = new Alumno();
            a3.setNombre("Carlos");
            a3.setMaterias(List.of(m3));
            

            m3.setAlumnos(List.of(a2, a3));

            this.materiaService.crear(m3);
            */

            Materia m = this.materiaService.seleccionarPorId(4);

            for(Alumno a : m.getAlumnos()){

                System.out.println(a.getNombre());
            }

            Alumno a = this.alumnoService.seleccionarPorId(1);

            for(Materia materia : a.getMaterias()){

                System.out.println(materia.getNombre());

            }
            
            return 0;

        }

    }
}
