package Services;

import Repository.EquipeRepository;
import com.esprit.tn.project1.entities.Equipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService {
    EquipeRepository er;

    public Equipe ajouterEquipe(Equipe equipe) {
        return er.save(equipe);
    }

}
