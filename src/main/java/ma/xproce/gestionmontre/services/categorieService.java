package ma.xproce.gestionmontre.services;

import ma.xproce.gestionmontre.entities.categorie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface categorieService {
    categorie savecategorie(categorie categorie); //"Create" pour créer un nouveau client s'il nexiste pas id
    categorie updatecategorie(categorie categorie);//"Update"
    void deletecategorieById(Long id);//"Delete by id"
    void deleteAllcategorie();//"Delete All"
    categorie getcategorieById(Long id); //"Read by id"
    List<categorie> getAllcategorie();//"Read All"


    //Modification a faire pour la pagination
    Page<categorie> getAllcategorieByPage(int page, int size);

}
