package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Inventory;
import ec.edu.uce.domain.repository.InventoryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InventoryRepositoryImpl implements InventoryRepository{

    @Inject
    private EntityManager em;

    @Override
    public void insertar(Inventory inventory) {

        this.em.persist(inventory);

    }

}
