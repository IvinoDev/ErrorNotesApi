package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Solution;

public interface SolutionService {
    Solution creersolution(Solution solution);
    //Solution modifiersolution(Long id_solution, Solution solution);
    //Solution modifiersolution(Long id_solution,Long id_compte, Solution solution);
    //Rechercher par mot clé

    //Solution modifiersolution(Long id, Long id_probleme, Solution solution, Long id_compte);

    Solution modifiersolution(Long id, Long id_compte, Solution solution);

    /*Solution rechercher(Solution solution);*/
    //Supprimer une solution
    String supprimersolution(Long id_solution);

    //Solution addsolution (Solution solution, Long id);
    Solution addsolution (Solution solution, Long id_probleme, Long id_compte);

    Solution verification (Long id, Long id_compte);
}
