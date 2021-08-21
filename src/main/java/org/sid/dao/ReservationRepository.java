package org.sid.dao;

import org.sid.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findAllByStatut(String statut);
    List<Reservation> findAllByNumeroReservation(String numero);
    Page<Reservation> findAllByStatut(String statut, Pageable pageable);
    Optional<Object> findById(Long id);
}
