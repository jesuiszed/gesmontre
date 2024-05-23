package ma.xproce.gestionmontre.repositories;

import ma.xproce.gestionmontre.entities.categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categorieRepository extends JpaRepository<categorie,Long> {
}
