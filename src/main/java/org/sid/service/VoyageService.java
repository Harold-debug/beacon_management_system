package org.sid.service;

import org.sid.entities.Voyage;

import java.util.List;

public interface VoyageService {
    void createVoyage(Voyage voyage);
    void updateVoyage(Voyage voyage);
    void deleteVoyage(Long id);

  /*  void saveOrUpdate(Voyage voyage);*/

    List<Voyage> getAllVoyage();

    Voyage getVoyageById(Long id);
}
