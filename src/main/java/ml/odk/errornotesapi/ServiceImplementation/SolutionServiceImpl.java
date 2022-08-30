package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Repository.SolutionRepository;
import ml.odk.errornotesapi.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
@Data
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    //sr est le sigle de solutionRepository
    private final SolutionRepository sr;

    @Autowired
    ProblemeRepository pr;

    @Override
    public Solution creersolution(Solution solution) {
        return sr.save(solution);
    }

    @Override
    public Solution modifiersolution(Long id, Solution solution) {
        return sr.findById(id)
                .map(s->{
                    s.setDescription(solution.getDescription());
                    s.setEstimation(solution.getEstimation());
                    s.setRessource(solution.getRessource());
                    s.setMethodologie(solution.getMethodologie());
                    return sr.save(s);
                }).orElseThrow(() -> new RuntimeException("Modification interdite."));
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


    //Méthode Amagarai toujours
    @Override
    public Solution addsolution(Solution solution, Long id) {
        //Récupération du pb à l'aide de son id
        Probleme probleme = pr.findById(id).get(); //get permet de retourner le pb correspondant et find le trouver
        //Assigner le pb récupéré ou lier ce pb à la solution qui va être postée
        solution.setProblemes(probleme);
        //Ajout de la date à laquelle la solution a été posté
        solution.setDate(LocalDate.now());
        //Début méthode pour calculer le temps entre la date du pb et la date de la solution
        //puis la stocker dans l'attribut estimation, au lieu d'avoir un string pour cela
        //plus besoin de le spécifier car automatique
        LocalDate date = LocalDate.now();
        LocalDate datepb = solution.getProblemes().getDate();
        Duration difference = Duration.between(datepb.atStartOfDay(), date.atStartOfDay());
        solution.setEstimation("" + difference);


        //sauvegarde de la solution
        return sr.save(solution);
    }
}
