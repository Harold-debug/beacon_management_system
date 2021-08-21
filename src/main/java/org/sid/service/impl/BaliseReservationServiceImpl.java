package org.sid.service.impl;

import org.sid.dao.BaliseReservationRepository;
import org.sid.entities.BaliseReservation;
import org.sid.service.BaliseReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class BaliseReservationServiceImpl implements BaliseReservationService {

    @Autowired
    BaliseReservationRepository baliseReservationRepository;
    @Autowired
    BaliseReservationService baliseReservationService;
    @Override
    public void createBaliseReservation(BaliseReservation baliseReservation) {
        baliseReservationRepository.save(baliseReservation);
    }
  /*  public List<BaliseReservation> findAllByReservation(String reservation){
        List<BaliseReservation> baliseReservation = new ArrayList<BaliseReservation>();
        baliseReservationRepository.findAllByReservation(reservation).forEach(baliseReservation1 -> baliseReservation.add(baliseReservation1));
        return baliseReservation;
    }*/
    @Override
    public void deleteBaliseReservation(Long id) {
        BaliseReservation baliseReservation =  findById(id);
        if (baliseReservation != null) {
            baliseReservationRepository.delete(baliseReservation);
        }
    }

    @Override
    public List<BaliseReservation> getAllBaliseReservation() {
        List<BaliseReservation> baliseReservation = new ArrayList<BaliseReservation>();
        baliseReservationRepository.findAll().forEach(baliseReservation1 -> baliseReservation.add(baliseReservation1));
        return baliseReservation;
    }

    @Override
    public BaliseReservation findById(Long id) {
        return baliseReservationRepository.findById(id).orElse(null);

    }

    @Override
    public BaliseReservation getBaliseReservationById(Long id) {
        return baliseReservationRepository.findById(id).get();    }
}
