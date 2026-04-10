package Services;

import Repository.ContratRepository;
import com.esprit.tn.project1.entities.Contrat;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService{
    private final ContratRepository contratRepository;
 @Scheduled(fixedRate = 30000)
 public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {
     int anneeCourante = Year.now().getValue();
     List<Contrat> contrats = contratRepository.findAll();
     for (Contrat c : contrats) {
         // 🔥 convertir String → int
         int anneeContrat = Integer.parseInt(c.getAnnee());

         if (anneeContrat < anneeCourante) {
             c.setArchived(true);
             contratRepository.save(c);
         }
         List<Contrat> actifs = contratRepository.findByArchivedFalse();

         for (Contrat contratActif : actifs) {
             if (contratActif.getEquipe() != null) {
                 System.out.println("L'équipe " + c.getEquipe().getLibelle() +
                         " a un contrat actif de " + c.getMontant() +
                         " DT pour l'année " + c.getAnnee());
             }
         }
     }}}


