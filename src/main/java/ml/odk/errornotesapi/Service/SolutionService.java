package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Solution;

import java.util.List;

public interface SolutionService {

    //Pour créer une solution
    Solution addsolution (Solution solution, Long id_probleme, Long id_compte);

    //Pour modifier une solution
    Solution modifiersolution(Long id, Long id_compte, Solution solution);

    //Pour afficher la liste des solutions
    List<Solution>liresolution();

    //Pour supprimer une solution
    String supprimersolution(Long id_solution);

    //Pour vérifier l'existance d'une solution pour un problème donné
    Solution verification (Long id);
}
