package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Balise implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String matriculationBalise;
    private long numeroSerie;
    private String nomFlotte;
    private String codeFlotte;
    private String numeroSim;
    private String statutFonctionel;
   /* @ManyToOne
    private Site site;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatriculationBalise() {
        return matriculationBalise;
    }

    public void setMatriculationBalise(String matriculationBalise) {
        this.matriculationBalise = matriculationBalise;
    }

    public long getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(long numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNomFlotte() {
        return nomFlotte;
    }

    public void setNomFlotte(String nomFlotte) {
        this.nomFlotte = nomFlotte;
    }

    public String getCodeFlotte() {
        return codeFlotte;
    }

    public void setCodeFlotte(String codeFlotte) {
        this.codeFlotte = codeFlotte;
    }

    public String getNumeroSim() {
        return numeroSim;
    }

    public void setNumeroSim(String numeroSim) {
        this.numeroSim = numeroSim;
    }

    public String getStatutFonctionel() {
        return statutFonctionel;
    }

    public void setStatutFonctionel(String statutFonctionel) {
        this.statutFonctionel = statutFonctionel;
    }
}
