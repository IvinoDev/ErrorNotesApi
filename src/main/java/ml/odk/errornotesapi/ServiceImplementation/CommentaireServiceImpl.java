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
<<<<<<< HEAD

        return null;
    }

    @Override
    public Commentaire modifier(Commentaire commentaire) {

        return null;
=======
        return cr.save(commentaire);
    }

    @Override
    public Commentaire modifier(Long id, Commentaire commentaire) {
        return cr.findById(id)
                .map(c1 ->{
                    c1.setMessage(commentaire.getMessage());
                    c1.setDate(commentaire.getDate());
                    return cr.save(c1);
                }).orElseThrow(() -> new RuntimeException("Modification impossible"));
>>>>>>> bb81a1086c4219a6001287d957821d8d025188f9
    }


    @Override
    public List<Commentaire> lire() {
<<<<<<< HEAD

        return null;
=======
        return cr.findAll();
>>>>>>> bb81a1086c4219a6001287d957821d8d025188f9
    }

    @Override
    public String supprimer(Long id, Commentaire commentaire) {
        cr.deleteById(id);
        return "commentaire supprimé avec succès";
    }


}
