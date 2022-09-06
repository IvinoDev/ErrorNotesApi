package ml.odk.errornotesapi.ServiceImplementation;

import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Repository.CommentaireRepository;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Repository.SolutionRepository;
import ml.odk.errornotesapi.Service.CommentaireService;
import ml.odk.errornotesapi.Service.SolutionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentaireServiceImplTest {

    @Autowired
    CommentaireRepository commentaireRepository;

    @Autowired
    CommentaireService commentaireService;

    @Autowired
    SolutionRepository solutionRepository;

    @Autowired
    SolutionService solutionService;

    @Autowired
    CompteRepository compteRepository;

    @Mock
    Solution solution;

    @Mock
    Compte compte;


    @Test
    void modifier() {
    }

    @Test
    void lire() {
    }

    @Test
    void addcommentaire() {
        Commentaire commentaire = new Commentaire();
        commentaire.setId_commentaire(1L);
        commentaire.setMessage("Jean n'est pas gentil");
        commentaire.setDate(LocalDate.now());
        commentaire.setHeure(LocalTime.now());
        List<Commentaire> liste = solution.getCommentaires();
        liste.add(commentaire);
        //commentaireRepository.save(commentaire);
    }

    @Test
    void supprimer() {
    }
}