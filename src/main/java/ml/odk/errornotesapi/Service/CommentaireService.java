package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Compte;

import java.util.List;

public interface CommentaireService {



    //Création d'un commentaire
    Commentaire creercommentaire(Commentaire commentaire);
    //modification  d'un commentaire
    Commentaire modifier(Long id_commentaire,Commentaire commentaire);
    // Afficher la liste des commentaore
    List<Commentaire> lire();
    //Suppression d'un commentaire
    String supprimer(Long id_commentaire);

    Commentaire addcommentaire (Commentaire commentaire, Long id_solution, Long id_compte);


    /*Commentaire Creer(Commentaire commentaire);
    List<Commentaire> lister();
    String Supprimer(Long id_Commentaire);*/
}
