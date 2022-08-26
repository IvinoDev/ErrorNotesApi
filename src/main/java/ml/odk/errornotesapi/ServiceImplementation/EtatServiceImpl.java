package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Etat;
import ml.odk.errornotesapi.Service.EtatService;
import org.springframework.stereotype.Service;

@Service
@Data
public class EtatServiceImpl implements EtatService {
    @Override
    public Etat definiretat(Etat etat) {
        return null;
    }
}
