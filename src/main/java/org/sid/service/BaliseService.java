package org.sid.service;

import org.sid.entities.Balise;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface BaliseService {

    public void createBalise(Balise balise );
    public void updateBalise(Balise balise);
    public void deleteBalise(Long id);


   /* public void stock_disponible(String matriculation_balise,
                                 String statut_fonctionel,
                                 String nom_flotte);
    public void stock_alert(String statut_fonctionel);*/

    public List<Balise> getAllBalise();
    public Balise findById(Long id);
    public Balise getBaliseById(Long id);
    public int prediction(Date date);
     Page< Balise > findPaginated(int pageNo, int pageSize);
    Page< Balise > findPaginated1(int pageNo, int pageSize, String statut);
    Page< Balise > findPaginated2(int pageNo, int pageSize,String statut);
    Page< Balise > findPaginated3(int pageNo, int pageSize,String statut);
    Page< Balise > findPaginated4(int pageNo, int pageSize,String nomFlotte);
    Page< Balise > findPaginated5(int pageNo, int pageSize,String nomFlotte);
    Page< Balise > findPaginated6(int pageNo, int pageSize,String nomFlotte);


    /*public void saveOrUpdate(Balise balise);*/

    ;
}
