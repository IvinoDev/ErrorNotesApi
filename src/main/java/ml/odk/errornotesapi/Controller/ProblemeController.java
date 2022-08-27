package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/probleme")
public class ProblemeController {
    @Autowired
    ProblemeService ps;

    @GetMapping("/recherche/{mot_cle}")
    Object recherche(@PathVariable String mot_cle) {
        return ps.recherche(mot_cle);
    }

    /*@PostMapping("/poster/{id_probleme}")
    String ajouter(@RequestBody Probleme probleme, @PathVariable Long id_probleme){
        if(this.ps.creerprobleme(probleme, id_probleme) == null){
            return "ce problème existe deja";
        }
        return "problème ajouté avec succès";
    }*/

    @PostMapping("/poster")
    String ajouter(@RequestBody Probleme probleme){
        if(this.ps.creerprobleme(probleme) == null){
            return "ce problème existe deja";
        }
        return "problème ajouté avec succès";
    }

    @PutMapping("/modifier/{id_probleme}")
    Probleme modifier(@RequestBody Probleme probleme, @PathVariable Long id_probleme){
        return ps.modifier(id_probleme, probleme);
    }

    @DeleteMapping("/supprimer/{id_probleme}")
    String supprimer(@PathVariable Long id_probleme){
        return ps.supprimer(id_probleme);
    }


}
