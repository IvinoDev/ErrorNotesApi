package ml.odk.errornotesapi.Controller;

import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Repository.CommentaireRepository;
import ml.odk.errornotesapi.Repository.CompteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentaireControllerTest {

    @Autowired
    CommentaireRepository commentaireRepository;

    @Test
    void ajouter() {
        Commentaire commentaire = new Commentaire();
        commentaire.setMessage("Jean n'est pas gentil");
        commentaireRepository.save(commentaire);
    }


    @Test
    void modifier() {
        Commentaire commentaire = new Commentaire();
        commentaire.setMessage("Jean est sympathique");
        commentaireRepository.save(commentaire);
    }

    @Test
    void supprimer() {
        Commentaire test = new Commentaire();
        test.setId_commentaire(3L);
        test.setMessage("juste pour le test");
        Commentaire commentaireSave = commentaireRepository.save(test);
        commentaireRepository.deleteById(commentaireSave.getId_commentaire());
    }

    @Test
    void lister() {
        Commentaire testliste = new Commentaire();
        commentaireRepository.findAll();
    }
}