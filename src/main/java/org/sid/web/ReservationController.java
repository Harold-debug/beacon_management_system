package org.sid.web;

import org.sid.entities.Reservation;
import org.sid.service.impl.ReservationServiceImpl;
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
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationServiceImpl;


    @RequestMapping("/reservation")
    public String getAllReservation(Model model) {
       /* List<Reservation> list = reservationServiceImpl.getAllReservation();
        model.addAttribute("reservation", list);*/
        return findPaginated(1, model);
    }
    @GetMapping("/rev/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 5;
        Page<Reservation> page = reservationServiceImpl.findPaginated(pageNo, pageSize);
        List <Reservation> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("reservation", list);
        return "list-reservation";
    }
    @RequestMapping("/reservationTermine")
    public String findAllStatut(Model model) {
      /*  List<Reservation> list = reservationServiceImpl.findAllByStatut("Termine");
        model.addAttribute("reservation", list);
*/
        return findPaginated1(1, model);
    }
    @GetMapping("/rev1/{pageNo}")
    public String findPaginated1(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 5;
        Page<Reservation> page = reservationServiceImpl.findPaginated1(pageNo, pageSize,"TERMINE");
        List <Reservation> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("reservation", list);
        return "reservationTermine";
    }
    @RequestMapping("/reservationCours")
    public String findAllStatut1(Model model) {
        /*List<Reservation> list = reservationServiceImpl.findAllByStatut("EN COURS");
        model.addAttribute("reservation", list);*/

        return findPaginated2(1, model);
    }
    @GetMapping("/rev2/{pageNo}")
    public String findPaginated2(@PathVariable(value = "pageNo") int pageNo, Model model) {

        int pageSize = 5;
        Page<Reservation> page = reservationServiceImpl.findPaginated1(pageNo, pageSize,"EN COURS");
        List <Reservation> list= page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("reservation", list);
        return "reservationCours";
    }
    @RequestMapping("/numeroReservation")
    public String findAllMatriculationBalise(Model model, @Param("numero") String numero) {
        List<Reservation> list = reservationServiceImpl.findAllByNumeroReservation(numero);
        model.addAttribute("reservation", list);
        model.addAttribute("numero", numero);
        return "list-reservation";
    }
    @RequestMapping(path = {"/edit-reservation", "/edit-reservation/{id}"})
    public String editReservationById(Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
            Reservation reservation = reservationServiceImpl.getReservationById(id.get());
            model.addAttribute("reservation", reservation);
        } else {
            model.addAttribute("reservation", new Reservation());
        }
        return "add-edit-reservation";
    }

    @RequestMapping(path = "/delete-reservation/{id}")
    public String deleteReservation(Model model, @PathVariable("id") Long id){
        reservationServiceImpl.deleteReservation(id);
        return "redirect:/reservation";
    }

    @RequestMapping(path = "/createReservation", method = RequestMethod.POST)
    public String createReservation(Reservation reservation) {
        reservationServiceImpl.createReservation(reservation);
        return "redirect:/reservation";
    }

}
