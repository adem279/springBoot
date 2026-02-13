package Services;

import Repository.EquipeRepository;
import com.esprit.tn.project1.entities.Equipe;

public class EquipeService implements IEquipeService {
    EquipeRepository er;

    public Equipe ajouterEquipe(Equipe equipe) {
        return er.save(equipe);
    }

}
