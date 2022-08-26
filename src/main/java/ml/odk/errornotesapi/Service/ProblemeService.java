package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Probleme;

import java.util.List;

public interface ProblemeService {

    //Pour créer un probleme
    Probleme creerProbleme(Probleme probleme);

    //Pour modifier un probleme
    Probleme modifierProbleme(Probleme probleme);

    //Pour chercher un probleme
    Probleme rechercher(Probleme probleme);

    //Pour supprimer un probleme
    Probleme supprimerProbleme(Probleme probleme);
    public List<Probleme> problemes(String mot_cle);

}
