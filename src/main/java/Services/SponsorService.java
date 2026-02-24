package Services;

import Repository.SponsorRepository;
import com.esprit.tn.project1.entities.Sponsor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SponsorService implements ISponsorService{
    SponsorRepository sp;
    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {
        return sp.save(sponsor);

    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        return sp.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        return sp.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
     sp.deleteById(idSponsor);
    }

    @Override
    public List<Sponsor> listSponsors() {
        return sp.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {
        return sp.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        Sponsor sponsor=sp.findById(idSponsor).orElse(null);
        sponsor.setArchived(Boolean.TRUE);
        sp.save(sponsor);
        return sponsor.getArchived();
    }
}
