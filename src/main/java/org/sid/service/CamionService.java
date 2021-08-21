package org.sid.service;

import org.sid.entities.Camion;

import java.util.List;

public interface CamionService {
    public abstract void createCamion(Camion camion);
    public abstract void updateCamion(Camion camion);
    public abstract void deleteCamion(Long id);


    /*void saveOrUpdate(Camion camion);*/

    public List<Camion> getAllCamion();

    public Camion getCamionById(Long id);
}
