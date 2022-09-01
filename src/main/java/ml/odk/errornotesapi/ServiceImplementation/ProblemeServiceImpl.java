package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Etat;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Model.Type;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class ProblemeServiceImpl implements ProblemeService {

    // pr est le sigle de problemerepository
    @Autowired
    CompteRepository cr;
    //mieux de faire autowired ici
    private final ProblemeRepository pr;
    /*@Override
    public Probleme creerprobleme(Probleme probleme) {
        return pr.save(probleme);
    }*/

    @Override
    public String creerprobleme(Probleme probleme) {
        Optional<Probleme> problemeOptional=pr.findByTitre(probleme.getTitre());
        if(problemeOptional.isPresent()){
            return "Le problème existe déjà";
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
    public List<Probleme> recherche(String mot_cle) {
        List<Probleme> resultat = pr.findAll(mot_cle);
        if(mot_cle != null){
            System.out.println(resultat);
            if(resultat.size() != 0) {
                System.out.println("liste vide");
            } else {
                System.out.println("aucun probleme trouvé ");
            }
        }
        return resultat;

    }



    @Override
    public String supprimer(Long id_probleme) {
        pr.deleteById(id_probleme);
        return "Problème supprimé avec succès";
    }

    @Override
    public Probleme modifierEtat(Long id_probleme, Probleme probleme) {
        Probleme proo = new Probleme();

        return pr.findById(id_probleme).map(p->{
            p.setEtat(probleme.getEtat());
            return pr.save(p);
        }).orElseThrow(()->new RuntimeException("Vous ne pouvez pas changer l'état."));

    }

    //Méthode A
    @Override
    public Probleme addproblem(Probleme probleme, Long id) {
        //Permet de recupérer l'id de la personne connectée et de la retourner (sur le GUI / interface)
        Compte compte = cr.findById(id).get();
        //Pour que l'utilsateur présentement connecté crée le problème
        probleme.setCompte(compte);
        //Pour enregistrer la date à laquelle le problème a été crée
        probleme.setDate(new Date());
        //pour que l'état soit initial à la création du pb
        probleme.setEtat(Etat.initie);
        return pr.save(probleme);
    }


}
