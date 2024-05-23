package ma.xproce.gestionmontre.repositories;

import ma.xproce.gestionmontre.entities.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository extends JpaRepository<client,Long> {
}
