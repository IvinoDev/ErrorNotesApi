package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Compte;

import java.util.List;

public interface CommentaireService {



    //Création d'un commentaire
    Commentaire creercommentaire(Commentaire commentaire);
    //modification  d'un commentaire
    Commentaire modifier(Commentaire commentaire);
    // Afficher la liste des utilisateurs
    List<Commentaire> lire();
    //Suppression d'un commentaire
    Commentaire supprimer(Commentaire commentaire);
}
