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

@Service
@Data
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    //sr est le sigle de solutionRepository
    private final SolutionRepository sr;
    private final CompteRepository cr;

    @Autowired
    ProblemeRepository pr;

    @Override
    public Solution creersolution(Solution solution) {
        return sr.save(solution);
    }

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
                            s.setEstimation(solution.getEstimation());
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


   /* @Override
    public Solution rechercher(Solution solution) {
        return null;
    } */

    @Override
    public String supprimersolution(Long id_solution) {
        sr.deleteById(id_solution);
        return "Solution supprimée avec succès";
    }


    @Override
    public Solution verification(Long id) {

        Probleme probleme = pr.findById(id).get();

        return sr.findByProblemes(probleme);
    }

    //Méthode A
    @Override
    public Solution addsolution(Solution solution, Long id_probleme, Long id_compte) {
        //Récupération du pb à l'aide de son id
        try {


        Compte user = cr.findById(id_compte).get();
        Probleme probleme = pr.findById(id_probleme).get(); //get permet de retourner le pb correspondant et find le trouver
       if (user == probleme.getCompte()) {
           //Changement de l'état du pb en résolu lors qd la solution est créee
           //récup du pb puis changement de son état
           probleme.setEtat(Etat.resolu);

           //Ancienne méthode: solution.getProblemes().setEtat(Etat.resolu);
           //Sauvegarde du pb avec le nouvel Etat
           //pr.save(probleme);
           //Assigner le pb récupéré ou lier ce pb à la solution qui va être postée
           //solution.setProblemes(probleme);
           //Ajout de la date à laquelle la solution a été postée
           solution.setDate(new Date());
           //solution.setDate(LocalDate.now());
           //Début méthode pour calculer le temps entre la date du pb et la date de la solution
           //puis la stocker dans l'attribut estimation, au lieu d'écrire un string pour cela
           //plus besoin de le spécifier car automatique
        /*LocalDate date = LocalDate.now();
        LocalDate datepb = solution.getProblemes().getDate();*/
           //Methode B
           Date date = new Date();
           Date datepb = probleme.getDate();
           //long l= (date.getTime() - datepb.getTime())/(1000 * 60);

           //Date datepb = solution.getProblemes().getDate();


           //Nous alons calculer le temps consacrer
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
           /*System.err.println(l);
           System.err.println(dateminute);
           System.err.println(minute);
           System.err.println(annee);
           System.err.println(date.getTime());*/
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
                               System.err.println("Probleme creer a l'instant, donc estimation egale a 0");
                           }
                       }
                   }
               }
           }

           solution.setEstimation(l + " minutes");


           //date.get
           //Duration difference = Duration.between(datepb.atStartOfDay(), date.atStartOfDay());
           //en suivant la logique
           //Duration difference = Duration.between(datepb, date);
           //difference.toString();
           //solution.setEstimation("" + difference);
           //sauvegarde de la solution
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