package ma.xproce.gestionmontre.repositories;

import ma.xproce.gestionmontre.entities.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order1Repository extends JpaRepository<Order1,Long> {
}
