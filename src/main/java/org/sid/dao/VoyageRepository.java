package org.sid.dao;

import org.sid.entities.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    List<Voyage> findAllByCodeVoyage(Long code);
}
