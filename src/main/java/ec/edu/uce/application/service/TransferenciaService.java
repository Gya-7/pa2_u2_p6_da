package ec.edu.uce.application.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.CuentaRepository;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TransferenciaService {

    @Inject
    private TransferenciaRepository tRepository;

    @Inject
    private CuentaRepository cRepository;

    public void crear(Transferencia transferencia){

        this.tRepository.insert(transferencia);
    }

    @Transactional
    public void realizarTransferencia(String cuentaOrigen, String cuentaDestino,  BigDecimal valor){

        Cuenta c1 = this.cRepository.findByNumCuenta(cuentaOrigen);
        Cuenta c2 = this.cRepository.findByNumCuenta(cuentaDestino);


        if(c1.getMonto().compareTo(valor) >= 0){

            BigDecimal valorResultado = c1.getMonto().subtract(valor);
            c1.setMonto(valorResultado);
            BigDecimal valorNuevo = c2.getMonto().add(valor);
            c2.setMonto(valorNuevo);

        }

        Transferencia t = new Transferencia();
        t.setCuentaDestino(this.cRepository.findByNumCuenta(cuentaDestino));
        t.setCuentaOrigen(this.cRepository.findByNumCuenta(cuentaOrigen));
        t.setValor(valor);
        t.setFecha(LocalDate.now());

        c1.setTransferenciasRealizadas(List.of(t));
        c2.setTransferenciasRecibidas(List.of(t));

        this.crear(t);

    }

}
