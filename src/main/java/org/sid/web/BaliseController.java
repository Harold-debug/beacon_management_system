package org.sid.web;

import org.sid.entities.Balise;
import org.sid.service.impl.BaliseServiceImpl;
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
public class BaliseController {

    @Autowired
    BaliseServiceImpl baliseServiceImpl;


    @RequestMapping("/home")
    public String getAllBalise(Model model) {
           /* List<Balise> list = baliseServiceImpl.getAllBalise();
            List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
             model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());
            model.addAttribute("balise", list);*/

            return findPaginated(1, model);
    }
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {

        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        int pageSize = 5;
        Page<Balise> page = baliseServiceImpl.findPaginated(pageNo, pageSize);
        List <Balise> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("balise", list);
        return "home";
    }
    @GetMapping("/vol/{pageNo}")
    public String findPaginated1(@PathVariable(value = "pageNo") int pageNo, Model model) {

        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        int pageSize = 5;
        Page<Balise> page = baliseServiceImpl.findPaginated1(pageNo, pageSize,"DISPONIBLE");
        List <Balise> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("balise", list);
        return "baliseDisponible";
    }

    @RequestMapping("/baliseDisponible")
    public String findAllStatutFonctionel(Model model) {
       /* List<Balise> list = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balise", list);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());*/
        return findPaginated1(1, model);
    }
    @RequestMapping("/baliseVoyage")
    public String findAllStatutFonctionel1(Model model) {
        List<Balise> list = baliseServiceImpl.findAllByStatutFonctionel("EN VOYAGE");
        model.addAttribute("balise", list);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());
        return findPaginated2(1, model);
    }
    @GetMapping("/vol2/{pageNo}")
    public String findPaginated2(@PathVariable(value = "pageNo") int pageNo, Model model) {

        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        int pageSize = 5;
        Page<Balise> page = baliseServiceImpl.findPaginated2(pageNo, pageSize,"EN VOYAGE");
        List <Balise> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("balise", list);
        return "baliseVoyage";
    }
    @RequestMapping("/baliseAffecte")
    public String findAllStatutFonctionel2(Model model) {
        List<Balise> list = baliseServiceImpl.findAllByStatutFonctionel("AFFECTE");
        model.addAttribute("balise", list);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());
        return findPaginated3(1, model);
    }
    @GetMapping("/vol3/{pageNo}")
    public String findPaginated3(@PathVariable(value = "pageNo") int pageNo, Model model) {

        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        int pageSize = 5;
        Page<Balise> page = baliseServiceImpl.findPaginated3(pageNo, pageSize,"AFFECTE");
        List <Balise> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("balise", list);
        return "baliseAffecte";
    }
    @RequestMapping("/baliseDouala")
    public String findAllNomFlotte(Model model) {
        List<Balise> list = baliseServiceImpl.findAllByNomFlotte("Douala");
        model.addAttribute("balise", list);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        return findPaginated4(1, model);
    }
    @GetMapping("/vol4/{pageNo}")
    public String findPaginated4(@PathVariable(value = "pageNo") int pageNo, Model model) {

        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        int pageSize = 5;
        Page<Balise> page = baliseServiceImpl.findPaginated4(pageNo, pageSize,"Douala");
        List <Balise> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("balise", list);
        return "baliseDouala";
    }
    @RequestMapping("/baliseLimbe")
    public String findAllNomFlotte1(Model model) {
        List<Balise> list = baliseServiceImpl.findAllByNomFlotte("Limbe");
        model.addAttribute("balise", list);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        return findPaginated5(1, model);
    }
    @GetMapping("/vol5/{pageNo}")
    public String findPaginated5(@PathVariable(value = "pageNo") int pageNo, Model model) {

        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        int pageSize = 5;
        Page<Balise> page = baliseServiceImpl.findPaginated5(pageNo, pageSize,"Limbe");
        List <Balise> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("balise", list);
        return "baliseLimbe";
    }
    @RequestMapping("/baliseKribi")
    public String findAllNomFlotte2(Model model) {
        List<Balise> list = baliseServiceImpl.findAllByNomFlotte("Kribi");
        model.addAttribute("balise", list);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        return findPaginated6(1, model);
    }
    @GetMapping("/vol6/{pageNo}")
    public String findPaginated6(@PathVariable(value = "pageNo") int pageNo, Model model) {

        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        int pageSize = 5;
        Page<Balise> page = baliseServiceImpl.findPaginated6(pageNo, pageSize,"Kribi");
        List <Balise> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("balise", list);
        return "baliseKribi";
    }

    @RequestMapping("/matriculeBalise")
    public String findAllMatriculationBalise(Model model, @Param("matricule") String matricule) {
        List<Balise> list = baliseServiceImpl.findAllByMatriculationBalise(matricule);
        model.addAttribute("balise", list);
        model.addAttribute("matricule", matricule);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());

        return "home";
    }


    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editBaliseById(Model model, @PathVariable("id") Optional<Long> id){
            if (id.isPresent()) {
                Balise balise = baliseServiceImpl.getBaliseById(id.get());
                model.addAttribute("balise", balise);
            } else {
                model.addAttribute("balise", new Balise());
            }
            return "add-edit-beacon";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteBalise(Model model, @PathVariable("id") Long id){
            baliseServiceImpl.deleteBalise(id);
            return "redirect:/";
    }

    @RequestMapping(path = "/createBalise", method = RequestMethod.POST)
    public String createBalise(Balise balise) {
            baliseServiceImpl.createBalise(balise);
            return "redirect:/";
    }
    @RequestMapping("/prediction")
    public String prediction(Model model) {
        List<Balise> list = baliseServiceImpl.findAllByStatutFonctionel("EN VOYAGE");
        model.addAttribute("balise", list);
        List<Balise> balisesDisponible = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balisesDisponibleTaille", balisesDisponible.size());
        return "home";
    }
    
/*  @RequestMapping("/alert")
    public Boolean calculateSize(Model model) {
        List<Balise> list = baliseServiceImpl.findAllByStatutFonctionel("DISPONIBLE");
        model.addAttribute("balise", list);
        int count = list.size();
        if(count<200){
            return true;
        }
        else
        return false;
    }*/

}
