package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Reservation implements Serializable {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String numeroReservation;
    private long quantite;
    private long nombrePartie;
    private long nombreEntrer;
    private Date dateReservation;
    private String statut;

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public long getNombrePartie() {
        return nombrePartie;
    }

    public void setNombrePartie(long nombrePartie) {
        this.nombrePartie = nombrePartie;
    }

    public long getNombreEntrer() {
        return nombreEntrer;
    }

    public void setNombreEntrer(long nombreEntrer) {
        this.nombreEntrer = nombreEntrer;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public long getQuantite() {
        return quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}
