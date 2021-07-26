package org.sid.web;

import org.sid.entities.Balise;
import org.sid.entities.Camion;
import org.sid.entities.Site;
import org.sid.entities.Voyage;
import org.sid.service.impl.BaliseServiceImpl;
import org.sid.service.impl.CamionServiceImpl;
import org.sid.service.impl.SiteServiceImpl;
import org.sid.service.impl.VoyageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class VoyageController {

    @Autowired
    VoyageServiceImpl voyageServiceImpl;
    @Autowired
    SiteServiceImpl siteServiceImpl;
    @Autowired
    BaliseServiceImpl baliseServiceImpl;
    @Autowired
    CamionServiceImpl camionServiceImpl;


    @RequestMapping("/voyage")
    public String getAllVoyage(Model model) {
        List<Voyage> list = voyageServiceImpl.getAllVoyage();
        model.addAttribute("voyage", list);

        return "list-voyage";
    }
    @RequestMapping("/codeVoyage")
    public String findAllCodeVoyage(Model model, @Param("code") Long code) {
        List<Voyage> list = voyageServiceImpl.findAllByCodeVoyage(code);
        model.addAttribute("voyage", list);
        model.addAttribute("code", code);

        return "list-voyage";
    }
    @RequestMapping(path = {"/edit-voyage", "/edit-voyage/{id}"})
    public String editVoyageById(Model model, @PathVariable("id") Optional<Long> id){
        List<Camion> listCamion = camionServiceImpl.getAllCamion();
        model.addAttribute("camion", listCamion);
        List<Site> listDepart = siteServiceImpl.findAllByType("depart");
        model.addAttribute("siteDepart", listDepart);
        List<Site> listSArriver = siteServiceImpl.findAllByType("arriver");
        model.addAttribute("siteArriver", listSArriver);
        List<Balise> balisesDisponible1 = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille1", balisesDisponible1);
        if (id.isPresent()) {
           Voyage voyage = voyageServiceImpl.getVoyageById(id.get());
            model.addAttribute("voyage", voyage);
        } else {
            model.addAttribute("voyage", new Voyage());
        }
        return "add-edit-voyage";
    }

    @RequestMapping(path = "/delete-voyage/{id}")
    public String deleteVoyage(Model model, @PathVariable("id") Long id){
        voyageServiceImpl.deleteVoyage(id);
        return "redirect:/voyage";
    }

    @RequestMapping(path = "/createVoyage", method = RequestMethod.POST)
    public String createVoyage(Voyage voyage) {
        voyageServiceImpl.createVoyage(voyage);
        return "redirect:/voyage";
    }



}
