package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Voyage implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long codeVoyage;
    private String destination;
    private long annee;
    private Date dateDepart;
    private Date dateArriverPre;
    private Date dateArriverAct;
    @ManyToOne
    private Site site;
    @ManyToOne
    private Balise balise;
    @ManyToOne
    private Camion camion;
    private String marchandise;

    public String getMarchandise() {
        return marchandise;
    }

    public void setMarchandise(String marchandise) {
        this.marchandise = marchandise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodeVoyage() {
        return codeVoyage;
    }

    public void setCodeVoyage(long codeVoyage) {
        this.codeVoyage = codeVoyage;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArriverPre() {
        return dateArriverPre;
    }

    public void setDateArriverPre(Date dateArriverPre) {
        this.dateArriverPre = dateArriverPre;
    }

    public Date getDateArriverAct() {
        return dateArriverAct;
    }

    public void setDateArriverAct(Date dateArriverAct) {
        this.dateArriverAct = dateArriverAct;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getAnnee() {
        return annee;
    }

    public void setAnnee(long annee) {
        this.annee = annee;
    }

}
