package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.repository.CuentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CuentaService {

    @Inject
    private CuentaRepository cRepository;

    public void crear(Cuenta cuenta){

        this.cRepository.insert(cuenta);

    }

    public Cuenta seleccionarPorCuenta(String cuenta){

        return this.cRepository.findByNumCuenta(cuenta);

    }

}
