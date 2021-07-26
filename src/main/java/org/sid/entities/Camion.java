package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Camion implements Serializable {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String matriculationCamion;
    private String transporteur;


    public String getMatriculationCamion() {
        return matriculationCamion;
    }

    public void setMatriculationCamion(String matriculationCamion) {
        this.matriculationCamion = matriculationCamion;
    }

    public String getTransporteur() {
        return transporteur;
    }

    public void setTransporteur(String transporteur) {
        this.transporteur = transporteur;
    }




}
