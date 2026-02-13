package Repository;

import com.esprit.tn.project1.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
}
