package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Probleme;

import java.util.List;

public interface ProblemeService {

    //Création d'un problème
    String creerprobleme(Probleme probleme);
    //Probleme creerprobleme(Probleme probleme);
    //modification des informations d'un problème

    Probleme modifier(Long id_probleme, Long id_compte,  Probleme probleme);

    // Afficher la liste des problèmes
    List<Probleme> lire();

    //Rechercher par mot clé
    List<Probleme> recherche(String mot_cle);

    //Probleme rechercher(Probleme probleme);
    //Suppression d'un problème
    String supprimer(Long id_probleme);

    Probleme addproblem (Probleme probleme, Long id);

    Probleme modifierEtat(Long id_probleme, Probleme probleme);
}
