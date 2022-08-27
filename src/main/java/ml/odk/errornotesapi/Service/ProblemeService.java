package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Probleme;

import java.util.List;

public interface ProblemeService {

    //Création d'un problème
    Probleme creerprobleme(Probleme probleme);
    //modification des informations d'un problème

    Probleme modifier(Long id, Probleme probleme);

    // Afficher la liste des problèmes
    List<Probleme> lire();

    //Rechercher par mot clé
<<<<<<< HEAD
=======

    Object recherche(String mot_cle);

>>>>>>> bb81a1086c4219a6001287d957821d8d025188f9
    //Probleme rechercher(Probleme probleme);
    //Suppression d'un problème
    String supprimer(Long id);

    Object recherche(String mot_cle);
}
