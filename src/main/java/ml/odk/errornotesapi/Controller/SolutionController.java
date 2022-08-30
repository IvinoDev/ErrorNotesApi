package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/solution" )
public class SolutionController {
    @Autowired
    SolutionService solutionService;

    @PostMapping("/ajouter/{id_probleme}")
    Object ajouter(@RequestBody Solution solution, @PathVariable Long id_probleme){
        Solution s=solutionService.verification(id_probleme);
        if (s != null) {
            return "Solution déjà existante";
        } else {
            return solutionService.addsolution(solution, id_probleme);
        }
    }

    @PutMapping("/modifier/{id_solution}")
    Solution modifier(@PathVariable Long id_solution, @RequestBody Solution solution){
        return solutionService.modifiersolution(id_solution, solution);
    }

    @DeleteMapping("/supprimer/{id_solution}")
    String supprimer(@PathVariable Long id_solution){
        return solutionService.supprimersolution(id_solution);
    }
}
