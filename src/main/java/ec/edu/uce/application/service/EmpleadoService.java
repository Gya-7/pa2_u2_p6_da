package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmpleadoService {

    @Inject
    private EmpleadoRepository er;

    @Inject
    private CiudadanoService ciudadanoService;

    @Transactional
    public void crear(Empleado empleado){

        // Ciudadano c1 = new Ciudadano();
        //     c1.setNombre("Allulla");
        //     c1.setFechaNacimiento(LocalDateTime.of(2000, 05, 25, 0, 0));
            
        //     this.ciudadanoService.insertarCiudadano(c1); // esto es service

        //     c1.setNombre("Allullita");

        //empleado.setCiudadano(c1); //esto es setear

        this.er.insert(empleado);

    }


}
