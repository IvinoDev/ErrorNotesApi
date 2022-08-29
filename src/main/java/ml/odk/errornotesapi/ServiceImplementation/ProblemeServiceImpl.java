package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Etat;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ProblemeServiceImpl implements ProblemeService {

    // pr est le sigle de problemerepository
    private final ProblemeRepository pr;
    /*@Override
    public Probleme creerprobleme(Probleme probleme) {
        return pr.save(probleme);
    }*/

    @Override
    public String creerprobleme(Probleme probleme) {
        Optional<Probleme> problemeOptional=pr.findByTitre(probleme.getTitre());
        if(problemeOptional.isPresent()){
            return null;
        }
        probleme = this.pr.save(probleme);
        probleme.setEtat(Etat.initie);
        this.pr.save(probleme);
        return "Problème crée avec succés.";
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
            System.out.println(resultat);
            if(resultat.size() != 0) {
                return resultat;
            } else {
                return "Aucun résultat trouvé.";
            }
        }
        return pr.findAll() ;

    }



    @Override
    public String supprimer(Long id_probleme) {
        pr.deleteById(id_probleme);
        return "Problème Supprimé";
    }


}
