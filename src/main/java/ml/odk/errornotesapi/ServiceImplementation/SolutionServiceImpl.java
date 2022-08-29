package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Repository.SolutionRepository;
import ml.odk.errornotesapi.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    //sr est le sigle de solutionRepository
    private final SolutionRepository sr;
    @Override
    public Solution creersolution(Solution solution) {
        return sr.save(solution);
    }

    @Override
    public Solution modifiersolution(Long id, Solution solution) {
        return sr.findById(id)
                .map(s->{
                    s.setDescription(solution.getDescription());
                    s.setEstimation(solution.getEstimation());
                    s.setRessource(solution.getRessource());
                    s.setMethodologie(solution.getMethodologie());
                    return sr.save(s);
                }).orElseThrow(() -> new RuntimeException("Modification interdite."));
    }

    @Override
    public List<Solution> lireSolution() {
        return sr.findAll();
    }


   /* @Override
    public Solution rechercher(Solution solution) {
        return null;
    } */

    @Override
    public String supprimersolution(Long id) {
        return null;
    }

}
