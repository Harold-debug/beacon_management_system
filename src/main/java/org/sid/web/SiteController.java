package org.sid.web;

import org.sid.entities.Site;
import org.sid.service.impl.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class SiteController {

    @Autowired
    SiteServiceImpl siteServiceImpl;


    @RequestMapping("/site")
    public String getAllSite(Model model) {
       /* List<Site> listSite = siteServiceImpl.getAllSite();
        model.addAttribute("site", listSite);*/
        return findPaginated(1, model);
    }
    @GetMapping("/sit/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 5;
        Page<Site> page = siteServiceImpl.findPaginated(pageNo, pageSize);
        List <Site> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("site", list);
        return "list-site";
    }
    @RequestMapping("/siteDepartArriver")
    public String findAllType(Model model) {
        List<Site> listDepart = siteServiceImpl.findAllByType("depart");
        model.addAttribute("site", listDepart);
        List<Site> listSArriver = siteServiceImpl.findAllByType("arriver");
        model.addAttribute("site", listSArriver);

        return "home";
    }
    @RequestMapping("/siteDepart")
    public String findAllType1(Model model) {
        List<Site> listDepart = siteServiceImpl.findAllByType("depart");
        model.addAttribute("site", listDepart);
        return findPaginated1(1, model);
    }
    @GetMapping("/site/{pageNo}")
    public String findPaginated1(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 5;
        Page<Site> page = siteServiceImpl.findPaginated1(pageNo, pageSize,"depart");
        List <Site> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("site", list);
        return "siteDepart";
    }
    @RequestMapping("/siteArriver")
    public String findAllType2(Model model) {
        List<Site> listSArriver = siteServiceImpl.findAllByType("arriver");
        model.addAttribute("site", listSArriver);

        return findPaginated2(1, model);
    }
    @GetMapping("/site2/{pageNo}")
    public String findPaginated2(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 5;
        Page<Site> page = siteServiceImpl.findPaginated2(pageNo, pageSize,"arriver");
        List <Site> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("site", list);
        return "siteArriver";
    }
    @RequestMapping("/nomSite")
    public String findAllNomSite(Model model, @Param("nom") String nom) {
        List<Site> list = siteServiceImpl.findAllByNomSite(nom);
        model.addAttribute("site", list);
        model.addAttribute("nom", nom);
        return "list-site";
    }
    @RequestMapping(path = {"/edit-site", "/edit-site/{id}"})
    public String editSiteById(Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
           Site site = siteServiceImpl.getSiteById(id.get());
            model.addAttribute("site", site);
        } else {
            model.addAttribute("site", new Site());
        }
        return "add-edit-site";
    }

    @RequestMapping(path = "/delete-site/{id}")
    public String deleteSite(Model model, @PathVariable("id") Long id){
        siteServiceImpl.deleteSite(id);
        return "redirect:/site";
    }

    @RequestMapping(path = "/createSite", method = RequestMethod.POST)
    public String createBalise(Site site) {
        siteServiceImpl.createSite(site);
        return "redirect:/site";
    }

}
