package org.sid.dao;

import org.sid.entities.Balise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaliseRepository extends JpaRepository<Balise, Long> {
    List<Balise> findAllByStatutFonctionel(String statut);
    Page<Balise> findAllByStatutFonctionel(String statut, Pageable pageable);
    List<Balise> findAllByNomFlotte(String nomFlotte);
    Page<Balise> findAllByNomFlotte(String nomFlotte, Pageable pageable);
    List<Balise> findAllByMatriculationBalise(String matricule);




}
