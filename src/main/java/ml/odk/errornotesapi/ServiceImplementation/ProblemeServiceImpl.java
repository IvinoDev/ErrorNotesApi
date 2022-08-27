package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class ProblemeServiceImpl implements ProblemeService {

    // pr est le sigle de problemerepository
    private final ProblemeRepository pr;
    @Override
    public Probleme creerprobleme(Probleme probleme) {
        return pr.save(probleme);
    }

    @Override
    public Probleme modifier(Long id, Probleme probleme) {
        return pr.findById(id)
                .map(p->{
            p.setDescription(probleme.getDescription());
            p.setTitre(probleme.getTitre());
            p.setTechnologie(probleme.getTechnologie());
            return pr.save(p);

        }).orElseThrow(() -> new RuntimeException("Désole, Probleme non trouvé"));
    }

    @Override
    public List<Probleme> lire() {
        return pr.findAll();
    }

    @Override
    public Object recherche(String mot_cle) {
        if(mot_cle != null){
            List<Probleme> resultat = pr.findAll(mot_cle);
            if(resultat.size() != 0) {
                return resultat;
            } else {
                return "Aucun résultat trouvé.";
            }
        }
        return pr.findAll() ;

    }



    @Override
    public String supprimer(Long id) {
        pr.deleteById(id);
        return "Problème Supprimé";
    }


}
