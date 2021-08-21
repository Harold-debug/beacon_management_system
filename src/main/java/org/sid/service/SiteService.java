package org.sid.service;

import org.sid.entities.Site;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SiteService {
    public void createSite(Site site);
    public void updateSite(Site site);
    public  void deleteSite(Long id);
    public Site findById(Long id);


   /* void saveOrUpdate(Site site);*/

    List<Site> getAllSite();

    Site getSiteById(Long id);
    Page<Site> findPaginated(int pageNo, int pageSize);
    Page< Site> findPaginated1(int pageNo, int pageSize, String type);
    Page< Site > findPaginated2(int pageNo, int pageSize,String type);
}
