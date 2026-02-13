package Repository;

import com.esprit.tn.project1.entities.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiloteRepository extends JpaRepository<Pilote,Long> {
}
