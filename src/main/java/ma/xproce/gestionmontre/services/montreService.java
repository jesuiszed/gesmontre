package ma.xproce.gestionmontre.services;

import ma.xproce.gestionmontre.entities.montre;
import org.springframework.data.domain.Page;

import java.util.List;

public interface montreService {
    montre savemontre(montre montre);
    montre updatemontre(montre montre);
    void deletemontreById(Long id);
    void deleteAllmontre();
    montre getmontreById(Long id);
    List<montre> getAllmontre();
    //Modification a faire pour la pagination
    Page<montre> getAllmontreByPage(int page, int size);
}
