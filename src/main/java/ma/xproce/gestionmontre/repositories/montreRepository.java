package ma.xproce.gestionmontre.repositories;

import ma.xproce.gestionmontre.entities.montre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// pour marquer qu'il accèdent à la base de données et effectuent des opérations CRUD
public interface montreRepository extends JpaRepository<montre,Long> {
}


//JpaRepository est une interface fournie par Spring Data JPA,
// qui est une partie du projet Spring Data dans le Spring Framework.
// Elle simplifie l'interaction avec la base de données en fournissant une API de
// haut niveau pour accéder aux bases de données relationnelles via JPA (Java Persistence API)