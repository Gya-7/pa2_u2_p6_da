package ec.edu.uce;

import java.util.List;

import ec.edu.uce.application.service.GameCharacterService;
import ec.edu.uce.application.service.MissionService;
import ec.edu.uce.domain.model.GameCharacter;
import ec.edu.uce.domain.model.Mission;
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
        private GameCharacterService gcService;

        @Inject
        private MissionService mService;

        @Override
        public int run(String... args) {


            System.out.println("Inicio de Programa");
            /* 

            //INSERTAR POR JUGADOR
            GameCharacter gc = new GameCharacter();
            gc.setNickname("Wonwoo");
            gc.setType("Shooter");
            gc.setLevel(100);
            gc.setLifePoints(1560);

            Mission m1 = new Mission();
            m1.setTitulo("COnquistar la torre");
            m1.setDescription("Tienes 10 minutos para tomar el control de la torre, y mantenerte en el lugar hasta que acabe el tiempo. NO dejes que tus enemigos te la quiten");
            m1.setNivelRequerido(68);
            m1.setPoints(2600.25);

            Mission m2 = new Mission();
            m2.setTitulo("Se el ultimo de pie");
            m2.setDescription("Extermina a los demas jugadores, hasta que solo quedes tu");
            m2.setNivelRequerido(98);
            m2.setPoints(850.87);

            gc.setMissions(List.of(m1, m2));

            this.gcService.crear(gc);
            


            //INSERTAR POR MISIONES
            Mission m1 = new Mission();
            m1.setTitulo("Protege a tus companieros");
            m1.setDescription("Tus companieros y tu tienen que mantenerse dentro del circulo por 5 minutos y debes absorber el 50% de danio destinado a tu equipo");
            m1.setNivelRequerido(53);
            m1.setPoints(7946.59);


            GameCharacter gc = new GameCharacter();
            gc.setNickname("Jeoni");
            gc.setType("Tank");
            gc.setLevel(80);
            gc.setLifePoints(2600);
            gc.setMissions(List.of(m1));

            GameCharacter gc2 = new GameCharacter();
            gc2.setNickname("Karla");
            gc2.setType("Tank");
            gc2.setLevel(46);
            gc2.setLifePoints(2500);
            gc2.setMissions(List.of(m1));

            m1.setCharacters(List.of(gc, gc2));

            this.mService.crear(m1);

            */

            
            Mission lista = this.mService.seleccionarPorId(4);

            for(GameCharacter gameCharacter : lista.getCharacters()){

                System.out.println(gameCharacter.getNickname());

            }
            System.out.println("JUGADORES");


            
            GameCharacter lista2 = this.gcService.seleccionarPorId(3);

            for(Mission mission : lista2.getMissions()){

                System.out.println(mission.getTitle());

            }
            System.out.println("MISIONES");

            

            return 0;

        }

    }
}
