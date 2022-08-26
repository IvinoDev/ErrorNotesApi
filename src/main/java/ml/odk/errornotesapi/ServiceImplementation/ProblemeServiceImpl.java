package ml.odk.errornotesapi.ServiceImplementation;

import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemeServiceImpl implements ProblemeService {
    @Autowired
    ProblemeRepository repos;


    @Override
    public Probleme creerProbleme(Probleme probleme) {
        return null;
    }

    @Override
    public Probleme modifierProbleme(Probleme probleme) {
        return null;
    }

    @Override
    public Probleme rechercher(Probleme probleme) {
        return null;
    }

    @Override
    public Probleme supprimerProbleme(Probleme probleme) {
        return null;
    }

    @Override
    public List<Probleme> problemes(String mot_cle) {
        return null;
    }
}
