package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Inventory;
import ec.edu.uce.domain.repository.InventoryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InventoryService {

    @Inject
    private InventoryRepository invRepository;

    @Transactional
    public void crear(Inventory inventory){

        this.invRepository.insertar(inventory);

    }

}
