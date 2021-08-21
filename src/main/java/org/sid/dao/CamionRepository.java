package org.sid.dao;

import org.sid.entities.Camion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CamionRepository extends JpaRepository<Camion, Long> {
    List<Camion> findAllByMatriculationCamion(String matricule);
}
