package Services;

import Repository.PiloteRepository;
import com.esprit.tn.project1.entities.Pilote;

public class PiloteService implements IPiloteService{
    PiloteRepository pr;

    @Override
    public String addPilote(Pilote p) {
        Pilote savedPilote = pr.save(p);

        return "Pilote " + savedPilote.getLibelleP() +
                " ajouté avec succès avec l'ID: " + savedPilote.getIdPilote();
    }
}
