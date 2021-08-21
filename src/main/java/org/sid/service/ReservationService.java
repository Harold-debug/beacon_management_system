package org.sid.service;

import org.sid.entities.Reservation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReservationService {
    public void createReservation(Reservation reservation);
    public void updateReservation(Reservation reservation);
    public  void deleteReservation(Long id);

  /*  void saveOrUpdate(Reservation reservation);*/

    List<Reservation> getAllReservation();

    Reservation getReservationById(Long id);
    Page<Reservation> findPaginated(int pageNo, int pageSize);
    Page< Reservation > findPaginated1(int pageNo, int pageSize, String statut);
    Page< Reservation> findPaginated2(int pageNo, int pageSize,String statut);
}
