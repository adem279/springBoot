package Services;

import Repository.ContratRepository;
import Repository.SponsorRepository;
import com.esprit.tn.project1.entities.Contrat;
import com.esprit.tn.project1.entities.Sponsor;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Service
@AllArgsConstructor
public class SponsorService implements ISponsorService {

    private final ContratRepository contratRepository;   // ✅ AJOUT

    SponsorRepository sp;

    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {

        sponsor.setDateCreation(LocalDate.now());
        sponsor.setArchived(false);
        sponsor.setBloquerContrat(false);

        return sp.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {

        sponsors.forEach(s -> {
            s.setDateCreation(LocalDate.now());
            s.setArchived(false);
            s.setBloquerContrat(false);
        });

        return sp.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {

        sponsor.setDateDerniereModification(LocalDate.now());
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

        Sponsor sponsor = sp.findById(idSponsor).orElse(null);

        if (sponsor != null) {
            sponsor.setArchived(true);
            sp.save(sponsor);
            return true;
        }

        return false;
    }
    @Scheduled(cron = "0 0 9 ? * MON")
    public void calculBudgetSponsors() {

        System.out.println("Calcul budget sponsors...");

        List<Sponsor> sponsors = sp.findAll();

        for (Sponsor s : sponsors) {

            // 🔥 récupérer contrats de l'année courante
            List<Contrat> contrats = contratRepository.findBySponsorAndAnnee(
                    s, String.valueOf(Year.now().getValue())
            );

            // 🔥 somme des montants
            float total = 0;
            for (Contrat c : contrats) {
                if (c.getMontant() != null) {
                    total += c.getMontant();
                }
            }

            // ⚠️ éviter division par 0
            if (s.getBudgetAnnuel() == null || s.getBudgetAnnuel() == 0) {
                continue;
            }

            float pourcentage = (total / s.getBudgetAnnuel()) * 100;

            System.out.println("Sponsor : " + s.getNom() +
                    " | Budget utilisé : " + pourcentage + " %");

            // ⚠️ entre 70 et 100
            if (pourcentage > 70 && pourcentage < 100) {
                System.out.println("⚠ Attention budget presque consommé !");
            }

            // ❌ > 100
            if (pourcentage > 100) {
                System.out.println("❌ Budget dépassé → contrats bloqués");

                s.setBloquerContrat(true);
                sp.save(s);
            }
        }
    }

}