package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Compte;

import java.util.List;

public interface CommentaireService {



    //Création d'un commentaire (méthode obselète)
    //Commentaire creercommentaire(Commentaire commentaire);

    //modification  d'un commentaire
    Commentaire modifier(Long id_commentaire, Long id_compte, Commentaire commentaire);

    // Afficher la liste des commentaire
    List<Commentaire> lire();

    //Suppression d'un commentaire
    String supprimer(Long id_commentaire);

    //Création d'un commentaire
    Commentaire addcommentaire (Commentaire commentaire, Long id_solution, Long id_compte);


    /*Commentaire Creer(Commentaire commentaire);
    List<Commentaire> lister();
    String Supprimer(Long id_Commentaire);*/
}
