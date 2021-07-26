package org.sid.service.impl;

import org.sid.dao.VoyageRepository;
import org.sid.entities.Voyage;
import org.sid.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class VoyageServiceImpl implements VoyageService {
    @Autowired
    private VoyageRepository voyageRepository;
    @Autowired
    VoyageService voyageService;

    @Override
    public void createVoyage(Voyage voyage) {
       /* voyageService.saveOrUpdate(voyage);
        return voyage.getId();*/

        voyageRepository.save(voyage);
    }

    @Override
    public void updateVoyage(Voyage voyage) {
       /* voyageService.saveOrUpdate(voyage);
        return voyage.getId();*/

        voyageRepository.save(voyage);
    }

    @Override
    public void deleteVoyage(Long id) {
        Voyage voyage = findById(id);
        if (voyage != null) {
            voyageRepository.delete(voyage);
        }
    }
    public List<Voyage> findAllByCodeVoyage(Long code){
        List<Voyage> voyage = new ArrayList<Voyage>();
        voyageRepository.findAllByCodeVoyage(code).forEach(voyage1 -> voyage.add(voyage1));
        return voyage;
    }
    public Voyage findById(Long id) {
        return voyageRepository.findById(id).orElse(null);
    }

   /* @Override
    public void saveOrUpdate(Voyage voyage) {
        voyageRepository.save(voyage);
    }*/
    @Override
    public List<Voyage> getAllVoyage() {
       /* return voyageService.getAllVoyage();*/


        List<Voyage> voyage = new ArrayList<Voyage>();
        voyageRepository.findAll().forEach(voyage1 -> voyage.add(voyage1));
        return voyage;
    }

    @Override
    public Voyage getVoyageById(Long id) {
       /* return voyageService.getVoyageById(id);*/
        return voyageRepository.findById(id).get();

    }

}