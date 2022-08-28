package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Solution;

public interface SolutionService {
    Solution creersolution(Solution solution);
    Solution modifiersolution(Long id_solution, Solution solution);
    //Rechercher par mot clé

    /*Solution rechercher(Solution solution);*/
    //Supprimer une solution
    String supprimersolution(Long id_solution);
}
