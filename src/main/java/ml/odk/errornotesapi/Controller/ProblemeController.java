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

    //Injection du Service du Probleme sous le short name "ps" pour pouvoir utiliser les méthodes définies dedans
    @Autowired
    ProblemeService ps;

    //Pour créer un problème
    @PostMapping("/poster/{id_compte}")
    Probleme ajouter(@RequestBody Probleme probleme, @PathVariable Long id_compte) {
        return ps.addproblem(probleme, id_compte);
    }

    //Pour rechercher un problème
    @GetMapping("/recherche/{mot_cle}")
    List<Probleme> recherche(@PathVariable String mot_cle) {
        return ps.recherche(mot_cle);
    }


    //Pour modifier un problème
    @PutMapping("/modifier/{id_probleme}/{id_compte}")
    Probleme modifier (@RequestBody Probleme probleme, @PathVariable Long id_probleme, @PathVariable Long id_compte){
        return ps.modifier(id_probleme, id_compte, probleme);
    }


    //Modifier manuellement l'état d'un problème existant:
    @PutMapping("/modifier_etat/{id_probleme}")
    Probleme modifier(@PathVariable Long id_probleme, @RequestBody Probleme probleme){
        return ps.modifierEtat(id_probleme, probleme);
    }


    //Mapping pour la suppression d'un problème
    @DeleteMapping("/supprimer/{id_probleme}/{id_compte}")
    String supprimer (@PathVariable(value = "id_probleme") Long id_probleme, @PathVariable(value = "id_compte") Long id_compte) {
        return ps.supprimer(id_probleme, id_compte);
    }


    // Afficher la liste des problèmes
    @GetMapping("/lire")
    public List<Probleme>lireprobleme(){return ps.lire();
    }


    // SUPPRESSION OBSELETE
    /*@DeleteMapping("/supprimer/{id_probleme}")
    String supprimer(@PathVariable Long id_probleme) {
        Compte compt = new Compte();
        if (compt.getType() == Type.UserAdmin || compt.getType() == Type.User) {
            return ps.supprimer(id_probleme);
        }
        return  "Action non autorisée";
    }*/

    //CREATION OBSELETE
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

    //MODIFICATION OBSELETE
//    @PutMapping("/modifier/{id_probleme}")
//    Object modifier(@RequestBody Probleme probleme, @PathVariable Long id_probleme){
//        Compte compt = new Compte();
//        if (compt.getType() == Type.UserAdmin || compt.getType() == Type.User){
//            return ps.modifier(id_probleme, probleme);
//        }
//        return "Action non autorisée.";
//    } */

}
