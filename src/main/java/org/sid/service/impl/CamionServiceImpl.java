package org.sid.service.impl;

import org.sid.dao.CamionRepository;
import org.sid.entities.Camion;
import org.sid.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CamionServiceImpl implements CamionService {
    @Autowired
    private CamionRepository camionRepository;
    @Autowired
    CamionService camionService;
    @Override
    public void createCamion(Camion camion) {
       /* camionService.saveOrUpdate(camion);
        return camion.getId();*/

        camionRepository.save(camion);
    }

    @Override
    public void updateCamion(Camion camion) {
       /* camionService.saveOrUpdate(camion);
        return camion;*/

        camionRepository.save(camion);
    }

    @Override
    public void deleteCamion(Long id) {
        Camion camion =  findById(id);
        if (camion != null) {
            camionRepository.delete(camion);
        }
    }

   /* @Override
    public void saveOrUpdate(Camion camion) {
        camionRepository.save(camion);
    }*/

    private Camion findById(Long id) {
        return camionRepository.findById(id).orElse(null);

    }
    public List<Camion> findAllByMatriculationCamion(String matricule){
        List<Camion> camion = new ArrayList<>();
        camionRepository.findAllByMatriculationCamion(matricule).forEach(camion1 -> camion.add(camion1));
        return camion;
    }
    @Override
    public List<Camion> getAllCamion() {
        /*return camionService.getAllCamion();*/


        List<Camion> camion= new ArrayList<Camion>();
        camionRepository.findAll().forEach(camion1 -> camion.add(camion1));
        return camion;
    }

    @Override
    public Camion getCamionById(Long id) {
       /* return camionService.getCamionById(id);*/

        return camionRepository.findById(id).get();
    }
}
