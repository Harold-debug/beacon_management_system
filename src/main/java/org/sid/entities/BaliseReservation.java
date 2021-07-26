package org.sid.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class BaliseReservation {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Balise balise;
    @ManyToOne
    private Reservation reservation;
    private Date dateSortie;
    private Date dateRetour;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Balise getBalise() {
        return balise;
    }

    public void setBalise(Balise balise) {
        this.balise = balise;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }
}
