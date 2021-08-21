package org.sid.web;

import org.sid.entities.Balise;
import org.sid.entities.BaliseReservation;
import org.sid.entities.Reservation;
import org.sid.service.impl.BaliseReservationServiceImpl;
import org.sid.service.impl.BaliseServiceImpl;
import org.sid.service.impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class BaliseReservationController {
    @Autowired
    BaliseReservationServiceImpl baliseReservationServiceImpl;

    @Autowired
    ReservationServiceImpl reservationServiceImpl;

    @Autowired
    BaliseServiceImpl baliseServiceImpl;

    @RequestMapping("/baliseReservation")
    public String getAllBaliseRsevation(Model model) {
        List<BaliseReservation> list = baliseReservationServiceImpl.getAllBaliseReservation();
        model.addAttribute("baliseReservation", list);

        return "list-baliseReservation";
    }


    @RequestMapping(path = {"/edit-baliseReservation", "/edit-baliseReservation/{id}"})
    public String editBaliseReservationById(Model model, @PathVariable("id") Optional<Long> id){
        List<Balise> list1 = baliseServiceImpl.getAllBalise();
        model.addAttribute("balise", list1);
        List<Reservation> list2 = reservationServiceImpl.getAllReservation();
        model.addAttribute("reservation", list2);
        if (id.isPresent()) {
            BaliseReservation baliseReservation = baliseReservationServiceImpl.getBaliseReservationById(id.get());
            model.addAttribute("baliseReservation", baliseReservation);
        } else {
            model.addAttribute("baliseReservation", new BaliseReservation());
        }
        return "add-edit-baliseReservation";
    }

    @RequestMapping(path = "/delete-baliseReservation/{id}")
    public String deleteBaliseReservation(Model model, @PathVariable("id") Long id){
        baliseReservationServiceImpl.deleteBaliseReservation(id);
        return "redirect:/baliseReservation";
    }

    @RequestMapping(path = "/createBaliseReservation", method = RequestMethod.POST)
    public String createBaliseReservation(BaliseReservation baliseReservation) {
        baliseReservationServiceImpl.createBaliseReservation(baliseReservation);
        return "redirect:/baliseReservation";
    }

}
