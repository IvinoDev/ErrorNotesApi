package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Probleme;

import java.util.List;

public interface ProblemeService {

    //Création d'un problème
    Probleme addproblem (Probleme probleme, Long id);

    //modification des informations d'un problème
    Probleme modifier(Long id_probleme, Long id_compte, Probleme probleme);

    //Rechercher par mot clé d'un problème
    List<Probleme> recherche(String mot_cle);

    //Suppression d'un problème
    String supprimer(Long id_probleme, Long id_compte);

    //Modification manuelle de l'état d'un pb
    Probleme modifierEtat(Long id_probleme, Probleme probleme);

    // Afficher la liste des problèmes
    List<Probleme> lire();


    //Méthode obselète pour la création d'un pb
    //String creerprobleme(Probleme probleme);
}
