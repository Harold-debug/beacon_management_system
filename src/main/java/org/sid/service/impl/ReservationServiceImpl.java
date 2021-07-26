package org.sid.service.impl;

import org.sid.dao.ReservationRepository;
import org.sid.entities.Reservation;
import org.sid.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    ReservationService reservationService;

    @Override
    public void createReservation(Reservation reservation) {
        /*reservationService.saveOrUpdate(reservation);
        return reservation.getId();*/

        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
       /* reservationService.saveOrUpdate(reservation);
        return reservation;*/

        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation =  findById(id);
        if (reservation != null) {
            reservationRepository.delete(reservation);
        }
    }
    public List<Reservation> findAllByStatut(String statut){
        List<Reservation> reservation = new ArrayList<Reservation>();
        reservationRepository.findAllByStatut(statut).forEach(reservation1 -> reservation.add(reservation1));
        return reservation;
    }
    public List<Reservation> findAllByNumeroReservation(String numero){
        List<Reservation> reservation = new ArrayList<Reservation>();
        reservationRepository.findAllByNumeroReservation(numero).forEach(reservation1 -> reservation.add(reservation1));
        return reservation;
    }

   /* @Override
    public void saveOrUpdate(Reservation reservation) {
        reservationRepository.save(reservation);
    }*/

    @Override
    public List<Reservation> getAllReservation() {
      /*  return reservationService.getAllReservation();*/

        List<Reservation> reservation = new ArrayList<Reservation>();
        reservationRepository.findAll().forEach(reservation1 -> reservation.add(reservation1));
        return reservation;
    }

    @Override
    public Reservation getReservationById(Long id) {
       /* return reservationService.getReservationById(id);*/

        return (Reservation) reservationRepository.findById(id).get();
    }

    @Override
    public Page<Reservation> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.reservationRepository.findAll(pageable);
    }

    @Override
    public Page<Reservation> findPaginated1(int pageNo, int pageSize, String statut) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.reservationRepository.findAllByStatut(statut, pageable);
    }

    @Override
    public Page<Reservation> findPaginated2(int pageNo, int pageSize, String statut) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.reservationRepository.findAllByStatut(statut, pageable);
    }

    private Reservation findById(Long id) {
        return (Reservation) reservationRepository.findById(id).orElse(null);

    }

}
