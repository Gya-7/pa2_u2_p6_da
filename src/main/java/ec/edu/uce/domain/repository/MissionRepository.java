package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Mission;

public interface MissionRepository {

    public void insert(Mission mission);
    public Mission findById(Integer id);

}
