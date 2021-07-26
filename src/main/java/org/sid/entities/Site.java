package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Site<set> implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String nomSite;
    private String type;

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
