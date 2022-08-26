package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Service.SolutionService;
import org.springframework.stereotype.Service;

@Service
@Data
public class SolutionServiceImpl implements SolutionService {
    @Override
    public Solution creersolution(Solution solution) {
        return null;
    }

    @Override
    public Solution modifiersolution(Solution solution) {
        return null;
    }

    @Override
    public Solution rechercher(Solution solution) {
        return null;
    }

    @Override
    public Solution supprimersolution(Solution solution) {
        return null;
    }
}
