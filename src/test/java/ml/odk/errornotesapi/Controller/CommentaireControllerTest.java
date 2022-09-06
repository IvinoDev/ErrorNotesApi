package ml.odk.errornotesapi.Controller;

import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Repository.CommentaireRepository;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Service.CommentaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentaireControllerTest {

    @Autowired
    CommentaireService commentaireService;

    @Test
    void ajouter() {
        Commentaire commentaire = new Commentaire();
        commentaire.setId_commentaire(1L);
        commentaire.setMessage("Jean n'est pas gentil");
        commentaireService.addcommentaire(commentaire, 1L, 2L);
    }


    @Test
    void modifier() {
        Commentaire commentaire = new Commentaire();
        commentaire.getId_commentaire();
        commentaire.setMessage("Jean est sympathique");
        commentaireService.modifier(1L, 2L, commentaire);
    }

    @Test
    void supprimer() {
        Commentaire test = new Commentaire();
        test.setMessage("juste pour le test");
        commentaireService.addcommentaire(test, 2L, 3L);
        commentaireService.supprimer(1L);
    }

    @Test

    void lister() {
        List list= commentaireService.lire();
    }
}