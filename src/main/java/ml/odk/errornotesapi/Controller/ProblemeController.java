package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Model.Type;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/probleme")
public class ProblemeController {
    @Autowired
    ProblemeService ps;

    @GetMapping("/recherche/{mot_cle}")
    List<Probleme> recherche(@PathVariable String mot_cle) {
        return ps.recherche(mot_cle);
    }

    @PostMapping("/poster/{id_compte}")
    Probleme ajouter(@RequestBody Probleme probleme, @PathVariable Long id_compte) {
        return ps.addproblem(probleme, id_compte);
    }

    /*@PostMapping("/poster")
    String ajouter(@RequestBody Probleme probleme){
        if(this.ps.creerprobleme(probleme) == null){
            return "ce problème existe deja";
        }
        return "problème ajouté avec succès";
    } */

    /*@PostMapping("/poster")
    String ajouter(@RequestBody Probleme probleme){
        if(this.ps.creerprobleme(probleme) == null){
            return "ce problème existe deja";
        }
        return "problème ajouté avec succès";
    }*/

//    @PutMapping("/modifier/{id_probleme}")
//    Object modifier(@RequestBody Probleme probleme, @PathVariable Long id_probleme){
//        Compte compt = new Compte();
//        if (compt.getType() == Type.UserAdmin || compt.getType() == Type.User){
//            return ps.modifier(id_probleme, probleme);
//        }
//        return "Action non autorisée.";
//    }
    //MODIFIER LE PB
    @PutMapping("/modifier/{id_probleme}/{id_compte}")
    Probleme modifier (@RequestBody Probleme probleme, @PathVariable Long id_probleme, @PathVariable Long id_compte){
        return ps.modifier(id_probleme, id_compte, probleme);
    }

    //Modifier manuellement l'état d'un pb existant:
    @PutMapping("/modifier_etat/{id_probleme}")
    Probleme modifier(@PathVariable Long id_probleme, @RequestBody Probleme probleme){
        return ps.modifierEtat(id_probleme, probleme);
    }

    //PS: Ne jamais supprimer ce qu'il y'a dans la BDD en pratique
    /*@DeleteMapping("/supprimer/{id_probleme}")
    String supprimer(@PathVariable Long id_probleme) {
        Compte compt = new Compte();
        if (compt.getType() == Type.UserAdmin || compt.getType() == Type.User) {
            return ps.supprimer(id_probleme);
        }
        return  "Action non autorisée";
    }*/
    @DeleteMapping("/supprimer/{id_probleme}/{id_compte}")
    String supprimer (@PathVariable(value = "id_probleme") Long id_probleme, @PathVariable(value = "id_compte") Long id_compte) {
        return ps.supprimer(id_probleme, id_compte);
    }

}
