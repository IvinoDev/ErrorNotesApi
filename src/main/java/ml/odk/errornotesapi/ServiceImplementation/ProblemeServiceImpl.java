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

    //mieux de faire un autowired ici pour l'injection de ce repository
    private final ProblemeRepository pr;


    //Méthode pour créer un problème
    @Override
    public Probleme addproblem(Probleme probleme, Long id) {
        //Permet de recupérer l'id de la personne connectée et de la retourner (sur le GUI / l'interface)
        Compte compte = cr.findById(id).get();
        //Pour que l'utilsateur présentement connecté crée le problème
        probleme.setCompte(compte);
        //Pour enregistrer la date à laquelle le problème a été crée
        probleme.setDate(new Date());
        //pour que l'état soit initial à la création du pb
        probleme.setEtat(Etat.initie);
        return pr.save(probleme);
    }

    //Modification d'un problème via l'id du compte
    @Override
    public Probleme modifier(Long id_probleme, Long id_compte, Probleme probleme) {
        try {
            Probleme probleme1 = pr.findById(id_probleme).get();
            Compte user=cr.findById(id_compte).get();
            if(user==probleme1.getCompte()){
                return pr.findById(id_probleme)
                        .map(p -> {
                            p.setDescription(probleme.getDescription());
                            p.setTitre(probleme.getTitre());
                            p.setTechnologie(probleme.getTechnologie());
                            return pr.save(p);

                        }).orElseThrow(() -> new RuntimeException("Désole, Probleme non trouvé"));

            }else {
                return  null;
            }
        }catch (Exception e){
            return  null;
        }
    }


    //Pour l'affichage de la liste des problèmes
    @Override
    public List<Probleme> lire() {
        return pr.findAll();
    }


    //  la méthode pour rechercher un problème par mot de clé
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


    //Suppression d'un problème
    @Override
    public String supprimer(Long id_probleme, Long id_compte) {
        Compte user =cr.findById(id_compte).get();
        Probleme probleme = pr.findById(id_probleme).get();
        try {
            if(user ==probleme.getCompte()) {

                pr.deleteById(id_probleme);
                return "Problème supprimé avec succès";
            }else{
                return "Ce probleme ne vous appartient pas";
            }
    }catch (Exception e){
            return "Erreur impossible de supprimer le probleme";
        }
    }


    // Modification manuelle de l'état d'un problème
    @Override
    public Probleme modifierEtat(Long id_probleme, Probleme probleme) {
        Probleme proo = new Probleme();

        return pr.findById(id_probleme).map(p->{
            p.setEtat(probleme.getEtat());
            return pr.save(p);
        }).orElseThrow(()->new RuntimeException("Vous ne pouvez pas changer l'état."));

    }


    //Méthode obselète pour la création d'un problème
    /*@Override
    public String creerprobleme(Probleme probleme) {
        Optional<Probleme> problemeOptional=pr.findByTitre(probleme.getTitre());
        if(problemeOptional.isPresent()){
            return "Le problème existe déjà";
        }
        probleme = this.pr.save(probleme);
        probleme.setEtat(Etat.initie);
        this.pr.save(probleme);
        return "Problème crée avec succés.";
    }*/

}
