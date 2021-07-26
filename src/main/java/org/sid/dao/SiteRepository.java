package org.sid.dao;

import org.sid.entities.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> findAllByType(String type);
    List<Site> findAllByNomSite(String nom);
    Page<Site> findAllByType(String type, Pageable pageable);
    Optional<Site> findById(Long id);

}
