package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Solution;

import java.util.List;

public interface SolutionService {
    Solution creersolution(Solution solution);
    Solution modifiersolution( Long id, Solution solution);
    List<Solution> lireSolution();
    //Rechercher par mot clé

    /*Solution rechercher(Solution solution);*/

    String supprimersolution(Long id);
}
