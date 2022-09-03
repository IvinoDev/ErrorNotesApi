package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Etat;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Repository.CommentaireRepository;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Repository.SolutionRepository;
import ml.odk.errornotesapi.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Data
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    //Injection des différents Repository qui contiennent les méthodes dont on a besoin
    private final SolutionRepository sr;
    private final CompteRepository cr;
    @Autowired
    ProblemeRepository pr;


    //Pour la modification d'une solution
    @Override
    public Solution modifiersolution(Long id, Long id_compte, Solution solution) {
        //recuperation du compte qui pose le probleme;
        Compte user =cr.findById(id_compte).get();
        Solution solution1 =sr.findById(id).get();
        try {
            if (user ==solution1.getProblemes().getCompte()) {
                return sr.findById(id)
                        .map(s -> {
                            s.setDescription(solution.getDescription());
                            //s.setEstimation(solution.getEstimation());
                            s.setRessource(solution.getRessource());
                            s.setMethodologie(solution.getMethodologie());
                            return sr.save(s);
                        }).orElseThrow(() -> new RuntimeException("Modification interdite."));
            }else {
                return null;
            }
    }catch (Exception e){
            return  null;
        }
    }

    //Pour afficher la liste des solutions
    @Override
    public List<Solution> liresolution() {
        return sr.findAll();
    }


    //Pour la suppression des solutions
    @Override
    public String supprimersolution(Long id_solution) {
        sr.deleteById(id_solution);
        return "Solution supprimée avec succès";
    }


    //Pour vérifier si un problème n'a pas déjà une solution
    @Override
    public Solution verification(Long id) {
        Probleme probleme = pr.findById(id).get();
        return sr.findByProblemes(probleme);
    }


    //Méthode pour ajouter une solution
    @Override
    public Solution addsolution(Solution solution, Long id_probleme, Long id_compte) {
        try {
            //Récupération du compte et du problème via leurs ids
            Compte user = cr.findById(id_compte).get();
            Probleme probleme = pr.findById(id_probleme).get(); //get permet de retourner le pb correspondant et find le trouver
            if (user == probleme.getCompte()) {
               /*Pour le changement de l'état du pb en résolu lors qd la solution est créee
               Après récupèration du pb puis on change on état comme suit */
               probleme.setEtat(Etat.resolu);

               /*Ancienne méthode: solution.getProblemes().setEtat(Etat.resolu);
                Sauvegarde du pb avec le nouvel Etat
                pr.save(probleme);
                Puis on assigne le pb récupéré à la solution qui va être postée
                solution.setProblemes(probleme);*/

               //Ajout de la date à laquelle la solution a été postée
               solution.setDate(new Date());

               //Déclaration de variable pour le calcul de l'estimation
               Date date = new Date();
               //Récupération de la date du pb à laquelle on a ajouté la solution
               Date datepb = probleme.getDate();

               //Calcul de l'estimation en fonction de la date du pb qui est lié à la solution
               final long minute = 1000 * 60;
               final long heure = minute * 60;
               final long jour = heure * 24;
               final long annee = jour * 365;

               long l = 0;


               long dateannee = (date.getTime() - datepb.getTime()) / annee;
               long datemois = (date.getTime() - datepb.getTime()) / jour / 30;
               long datejours = (date.getTime() - datepb.getTime()) / jour;
               long dateheure = (date.getTime() - datepb.getTime()) / heure;
               long dateminute = (date.getTime() - datepb.getTime()) / (heure / 60);

               //Pour vérifier au niveau de la console
               System.err.println(datepb.getTime());


               if (dateannee > 0) {
                   l = dateannee;
               } else {
                   if (datemois > 0) {
                       l = datemois;
                   } else {
                       if (datejours > 0) {
                           l = datejours;
                       } else {
                           if (dateheure > 0) {
                               l = dateheure;
                           } else {
                               if (dateminute > 0) {
                                   l = dateminute;
                               } else {
                                   System.err.println("Probleme cree a l'instant, donc estimation egale a 0");
                               }
                           }
                       }
                   }
               }
               //Enregistrment de l'estimation
               solution.setEstimation(l + " minutes");

               //Puis sauvegarde de la solution
               solution.setProblemes(probleme);
               Solution s = sr.save(solution);
               probleme.setSolution(s);
               pr.save(probleme);
               return s;
            }else {
                return null;
            }
        }catch (Exception e){
                return null;
        }
    }

}