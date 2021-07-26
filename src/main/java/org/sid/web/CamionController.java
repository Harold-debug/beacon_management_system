package org.sid.web;

import org.sid.entities.Camion;
import org.sid.service.impl.CamionServiceImpl;
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
public class CamionController {

    @Autowired
    CamionServiceImpl camionServiceImpl;


    @RequestMapping("/camion")
    public String getAllCamion(Model model) {
        List<Camion> listCamion = camionServiceImpl.getAllCamion();
        model.addAttribute("camion", listCamion);
        return "list-camion";
    }
    @RequestMapping("/matriculeCamion")
    public String findAllMatriculationCamion(Model model, @Param("matricule") String matricule) {
        List<Camion> list = camionServiceImpl.findAllByMatriculationCamion(matricule);
        model.addAttribute("camion", list);
        model.addAttribute("matricule", matricule);
        return "list-camion";
    }
    @RequestMapping(path = {"/edit-camion", "/edit-camion/{id}"})
    public String editCamionById(Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
            Camion camion = camionServiceImpl.getCamionById(id.get());
            model.addAttribute("camion", camion);
        } else {
            model.addAttribute("camion", new Camion());
        }
        return "add-edit-camion";
    }

    @RequestMapping(path = "/delete-camion/{id}")
    public String deleteCamion(Model model, @PathVariable("id") Long id){
        camionServiceImpl.deleteCamion(id);
        return "redirect:/camion";
    }

    @RequestMapping(path = "/createCamion", method = RequestMethod.POST)
    public String createCamion(Camion camion) {
        camionServiceImpl.createCamion(camion);
        return "redirect:/camion";
    }



}
