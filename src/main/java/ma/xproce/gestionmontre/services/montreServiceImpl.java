package ma.xproce.gestionmontre.services;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.montre;
import ma.xproce.gestionmontre.repositories.montreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class montreServiceImpl implements montreService {
    private final montreRepository montreRepository;

    @Override
    public montre savemontre(montre montre) {
        return montreRepository.save(montre);
    }

    @Override
    public montre updatemontre(montre montre) {
        return montreRepository.save(montre);
    }

    @Override
    public void deletemontreById(Long id) {
        montreRepository.deleteById(id);
    }


    @Override
    public void deleteAllmontre() {
        montreRepository.deleteAll();
    }

    @Override
    public montre getmontreById(Long id) {
        return montreRepository.findById(id).orElse(null);
    }

    @Override
    public List<montre> getAllmontre() {
        return montreRepository.findAll();
    }

    //Modification a faire pour la pagination
    @Override
    public Page<montre> getAllmontreByPage(int page, int size) {
        return montreRepository.findAll(PageRequest.of(page, size));
    }
}
