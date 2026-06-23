package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Transferencia;

public interface TransferenciaRepository {

    public void insert(Transferencia transferencia);
    public Transferencia findById(Integer id);

}
