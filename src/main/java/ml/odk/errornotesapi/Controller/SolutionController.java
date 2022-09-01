package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Service.CompteService;
import ml.odk.errornotesapi.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/solution" )
public class SolutionController {
    @Autowired
    SolutionService solutionService;
    CompteService cs;

    @PostMapping("/ajouter/{id_probleme}/{id_compte}")
    Object ajouter(@RequestBody Solution solution, @PathVariable Long id_probleme, @PathVariable Long id_compte){
        Solution s=solutionService.verification(id_probleme, id_compte);
        if (s != null) {
            return "Solution déjà existante";
        } else {
            return solutionService.addsolution(solution, id_probleme, id_compte);
        }
    }

    @PutMapping("/modifier/{id_solution}/{id_compte}")
    Solution modifier(@PathVariable Long id_solution, @PathVariable Long id_compte, @RequestBody Solution solution){
        return solutionService.modifiersolution(id_solution, id_compte, solution);
    }

    @DeleteMapping("/supprimer/{id_solution}")
    String supprimer(@PathVariable Long id_solution){
        return solutionService.supprimersolution(id_solution);
    }
}
