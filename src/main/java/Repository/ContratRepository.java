package Repository;

import com.esprit.tn.project1.entities.Contrat;
import com.esprit.tn.project1.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {
    List<Contrat> findByArchivedFalse();
    List<Contrat> findBySponsorAndAnnee(Sponsor sponsor, String annee);
}
