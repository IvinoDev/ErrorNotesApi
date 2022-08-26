package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Solution;

public interface SolutionService {
    //Pour creer une solution
    Solution creerSolution(Solution solution);

    //Pour modifier une solution
    Solution modifierSolution(Solution solution);

    //Pour supprimer une solution
    Solution supprimerSolution(Solution solution);
}
