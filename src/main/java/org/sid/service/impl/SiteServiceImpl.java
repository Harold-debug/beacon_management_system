package org.sid.service.impl;

import org.sid.dao.SiteRepository;
import org.sid.entities.Site;
import org.sid.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public  class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    SiteService siteService;

    @Override
    public void createSite(Site site) {
      /* siteService.saveOrUpdate(site);
        return site.getId();*/

        siteRepository.save(site);
    }

    @Override
    public void updateSite(Site site) {
       /* siteService.saveOrUpdate(site);
        return site.getId();*/

        siteRepository.save(site);
    }

    @Override
    public void deleteSite(Long id) {
        Site site = findById(id);
        if (site != null){
            siteRepository.delete(site);
        }
    }
    @Override
    public Site findById(Long id) {
        return siteRepository.findById(id).orElse(null);
    }
   /* @Override
    public void saveOrUpdate(Site site) {
        siteRepository.save(site);
    }*/

    public List<Site> findAllByType(String type){
        List<Site> site = new ArrayList<Site>();
        siteRepository.findAllByType(type).forEach(site1 -> site.add(site1));
        return site;
    }
    public List<Site> findAllByNomSite(String nom){
        List<Site> site = new ArrayList<Site>();
        siteRepository.findAllByNomSite(nom).forEach(site1 -> site.add(site1));
        return site;
    }

    @Override
    public List<Site> getAllSite() {
       /* return siteService.getAllSite();*/

        List<Site> site = new ArrayList<Site>();
        siteRepository.findAll().forEach(site1 -> site.add(site1));
        return site;
    }
    @Override
    public Site getSiteById(Long id) {
        /*return siteService.getSiteById(id);*/

        return siteRepository.findById(id).get();
    }

    @Override
    public Page<Site> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.siteRepository.findAll(pageable);
    }

    @Override
    public Page<Site> findPaginated1(int pageNo, int pageSize, String type) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.siteRepository.findAllByType(type, pageable);
    }

    @Override
    public Page<Site> findPaginated2(int pageNo, int pageSize, String type) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.siteRepository.findAllByType(type, pageable);
    }
}







