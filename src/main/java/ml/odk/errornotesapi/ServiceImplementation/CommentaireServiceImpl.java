package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Service.CommentaireService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class CommentaireServiceImpl implements CommentaireService {
    @Override
    public Commentaire creercommentaire(Commentaire commentaire) {
        return null;
    }

    @Override
    public Commentaire modifier(Commentaire commentaire) {
        return null;
    }

    @Override
    public List<Commentaire> lire() {
        return null;
    }

    @Override
    public Commentaire supprimer(Commentaire commentaire) {
        return null;
    }
}
