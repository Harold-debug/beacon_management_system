package org.sid.service;

import org.sid.entities.BaliseReservation;

import java.util.List;

public interface BaliseReservationService {

    public void createBaliseReservation(BaliseReservation baliseReservation );
    public void deleteBaliseReservation(Long id);
    public List<BaliseReservation> getAllBaliseReservation();
    public BaliseReservation findById(Long id);
    public BaliseReservation getBaliseReservationById(Long id);
}
