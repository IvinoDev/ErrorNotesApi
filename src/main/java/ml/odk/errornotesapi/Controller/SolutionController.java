package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Message.ReponseMessage;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Service.SolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/solution")
public class SolutionController {
    //ssr est le sigle de solutionservice.
    private final SolutionService ssr;
    @PostMapping("/creer")
    public Object creersolution(@RequestBody Solution solution){
        try {
            return ssr.creersolution(solution);
        }catch (Exception e){
            return ReponseMessage.generateResponse("Cet solution "+solution.getDescription()+" existe deja", HttpStatus.OK, null);
        }


    }
    @GetMapping("/Lire")
    public List<Solution> lire(){
        return ssr.lireSolution();
    }
    @PutMapping("/modifier/{id}")
    public Solution modifier(@PathVariable Long id, @RequestBody Solution solution){
        return ssr.modifiersolution(id, solution);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return ssr.supprimersolution(id);
    }
}
