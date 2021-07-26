package org.sid.dao;

import org.sid.entities.Balise;
import org.sid.entities.BaliseReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaliseReservationRepository extends JpaRepository<BaliseReservation, Long> {
    List<Balise> findAllByReservation(String reservation);
}
