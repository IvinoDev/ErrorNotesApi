package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Etat;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Repository.CommentaireRepository;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Repository.SolutionRepository;
import ml.odk.errornotesapi.Service.CommentaireService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Service
@Data
public class CommentaireServiceImpl implements CommentaireService {

    //Injection des différents Repository qui contiennent les méthodes dont on a besoin
    //cr est le sigle de commentairerepository
    private final CommentaireRepository cr;

    @Autowired
    CompteRepository compteRepository;

    @Autowired
    SolutionRepository solutionRepository;

    @Autowired
    ProblemeRepository problemeRepository;


    //Pour la création d'un commentaire
    @Override
    public Commentaire addcommentaire(Commentaire commentaire, Long id_solution, Long id_compte) {
        //Récupération du compte de la solution avec leurs Id(s)
        Compte compte = compteRepository.findById(id_compte).get();
        Solution solution = solutionRepository.findById(id_solution).get();
        //Attribution du compte qui crée le commentaire, de sa date et de son l'heure
        commentaire.setCompte(compte);
        commentaire.setDate(LocalDate.now());
        commentaire.setHeure(LocalTime.now());
        commentaire.setSolution(solution);
        //Sauvegarde du commentaire
        cr.save(commentaire);
        // Créer une liste de commentaire qui sera égale des commentaires déjà postés pour la solution
        List<Commentaire> liste = solution.getCommentaires();
        // Ajout du commentaire à la liste des commentaires déjà là pour la solution
        liste.add(commentaire);
        //Ajout du nouveau commentaire avec les anciens
        solution.setCommentaires(liste);

        //Enregistrement du nouvel état
        problemeRepository.save(solution.getProblemes());
        //Enregistrement de la solution avec le nouveau commentaire
        solutionRepository.save(solution);
        //affichage du commentaire
        return commentaire;
    }


    //Pour la modification d'un commentaire
    @Override
    public Commentaire modifier(Long id_commentaire,Long id_compte, Commentaire commentaire) {
       try {
           Compte user =compteRepository.findById(id_compte).get();
           Commentaire commentaire1= cr.findById(id_commentaire).get();
        if (user == commentaire1.getCompte()) {
            return cr.findById(id_commentaire)
                    .map(c1 -> {
                        c1.setMessage(commentaire.getMessage());
                        c1.setDate(LocalDate.now());
                        return cr.save(c1);
                    }).orElseThrow(() -> new RuntimeException("Modification impossible"));
        }else {
            return  null;
        }
    }catch (Exception e){
           return null;
       }
    }


    //Pour afficher la liste des commentaires
    @Override
    public List<Commentaire> lire() {
        return cr.findAll();
    }


    //Pour la suppression d'un commentaire
    @Override
    public String supprimer(Long id_commentaire) {
        cr.deleteById(id_commentaire);
        return "commentaire supprimé avec succès";
    }

}
