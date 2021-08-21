package org.sid.service.impl;

import org.sid.dao.BaliseRepository;
import org.sid.entities.Balise;
import org.sid.service.BaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class BaliseServiceImpl implements BaliseService {
    @Autowired
    BaliseRepository baliseRepository;
    @Autowired
    BaliseService baliseService;

    @Override
    public void createBalise(Balise balise) {

      /*  baliseService.saveOrUpdate(balise);
        return balise.getId();*/

        baliseRepository.save(balise);
    }

    @Override
    public void updateBalise(Balise balise) {

      /*  baliseService.saveOrUpdate(balise);
        return balise;*/

        baliseRepository.save(balise);
    }

    public List<Balise> findAllByStatutFonctionel(String statut){
        List<Balise> balise = new ArrayList<Balise>();
        baliseRepository.findAllByStatutFonctionel(statut).forEach(balise1 -> balise.add(balise1));
        return balise;
    }
    public List<Balise> findAllByNomFlotte(String nomFlotte){
        List<Balise> balise = new ArrayList<Balise>();
        baliseRepository.findAllByNomFlotte(nomFlotte).forEach(balise1 -> balise.add(balise1));
        return balise;
    }
    public List<Balise> findAllByMatriculationBalise(String matricule){
        List<Balise> balise = new ArrayList<Balise>();
        baliseRepository.findAllByMatriculationBalise(matricule).forEach(balise1 -> balise.add(balise1));
        return balise;
    }
    @Override
    public void deleteBalise(Long id) {
        Balise balise =  findById(id);
        if (balise != null) {
            baliseRepository.delete(balise);
        }
    }

    public Balise findById(Long id) {
       return baliseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Balise> getAllBalise() {

        List<Balise> balise = new ArrayList<Balise>();
        baliseRepository.findAll().forEach(balise1 -> balise.add(balise1));
        return balise;

        /*return baliseService.getAllBalise();*/
    }

    @Override
    public Balise getBaliseById(Long id) {
        return baliseRepository.findById(id).get();

        /*return baliseService.getBaliseById(id);*/
    }

    @Override
    public int prediction(Date date) {
        int numSortant = 75;
        int numEntrant = 20;




        return 0;
    }

    @Override
    public Page<Balise> findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.baliseRepository.findAll(pageable);

    }

    @Override
    public Page<Balise> findPaginated1(int pageNo, int pageSize, String statut) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.baliseRepository.findAllByStatutFonctionel(statut, pageable);
    }

    @Override
    public Page<Balise> findPaginated2(int pageNo, int pageSize,String statut) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.baliseRepository.findAllByStatutFonctionel(statut, pageable);
    }

    @Override
    public Page<Balise> findPaginated3(int pageNo, int pageSize,String statut) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.baliseRepository.findAllByStatutFonctionel(statut, pageable);
    }

    @Override
    public Page<Balise> findPaginated4(int pageNo, int pageSize,String nomFlotte) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.baliseRepository.findAllByNomFlotte(nomFlotte, pageable);
    }

    @Override
    public Page<Balise> findPaginated5(int pageNo, int pageSize,String nomFlotte) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.baliseRepository.findAllByNomFlotte(nomFlotte, pageable);
    }

    @Override
    public Page<Balise> findPaginated6(int pageNo, int pageSize,String nomFlotte) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.baliseRepository.findAllByNomFlotte(nomFlotte, pageable);
    }

  /*  @Override
    public void saveOrUpdate(Balise balise) {
        baliseRepository.save(balise);

    }*/


}
