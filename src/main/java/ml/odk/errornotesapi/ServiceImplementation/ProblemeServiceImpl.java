package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class ProblemeServiceImpl implements ProblemeService {
    @Override
    public Probleme creeruser(Probleme probleme) {
        return null;
    }

    @Override
    public Probleme modifier(Probleme probleme) {
        return null;
    }

    @Override
    public List<Probleme> lire() {
        return null;
    }

    @Override
    public Probleme rechercher(Probleme probleme) {
        return null;
    }

    @Override
    public Probleme supprimer(Probleme probleme) {
        return null;
    }
}
