package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Cuenta;

public interface CuentaRepository {

    public void insert(Cuenta cuenta);
    public Cuenta findByNumCuenta(String numCuenta);

}
