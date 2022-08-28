package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Repository.CommentaireRepository;
import ml.odk.errornotesapi.Service.CommentaireService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class CommentaireServiceImpl implements CommentaireService {
    //cr est le sigle de commentairerepository
    private final CommentaireRepository cr;
    @Override
    public Commentaire creercommentaire(Commentaire commentaire) {
        return null;
    }

    /*@Override
    public Commentaire modifier(Commentaire commentaire) {
        return cr.save(commentaire);
    }*/

    @Override
    public Commentaire modifier(Long id_commentaire, Commentaire commentaire) {
        return cr.findById(id_commentaire)
                .map(c1 ->{
                    c1.setMessage(commentaire.getMessage());
                    c1.setDate(commentaire.getDate());
                    return cr.save(c1);
                }).orElseThrow(() -> new RuntimeException("Modification impossible"));
    }


    @Override
    public List<Commentaire> lire() {
        return cr.findAll();
    }

    @Override
    public String supprimer(Long id_commentaire) {
        cr.deleteById(id_commentaire);
        return "commentaire supprimé avec succès";
    }

}
