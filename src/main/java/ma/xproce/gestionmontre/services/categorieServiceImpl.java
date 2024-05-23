package ma.xproce.gestionmontre.services;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.categorie;
import ma.xproce.gestionmontre.repositories.categorieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class categorieServiceImpl implements categorieService {

    private categorieRepository categorieRepository;
    @Override
    public categorie savecategorie(categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public categorie updatecategorie(categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deletecategorieById(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public void deleteAllcategorie() {
        categorieRepository.deleteAll();
    }

    @Override
    public categorie getcategorieById(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<categorie> getAllcategorie() {
        return categorieRepository.findAll();
    }


    //Modification a faire pour la pagination


    @Override
    public Page<categorie> getAllcategorieByPage(int page, int size) {
        return categorieRepository.findAll(PageRequest.of(page, size));
    }
}
