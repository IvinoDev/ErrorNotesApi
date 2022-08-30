package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/commentaire" )
public class CommentaireController {
    @Autowired
    CommentaireService cs;
    /*@PostMapping("/ajouter")
    Commentaire ajouter(@RequestBody Commentaire commentaire){

        //return cs.creercommentaire(commentaire);
    }*/

    @PostMapping("/ajouter/{id_compte}/{id_solution}")
    Commentaire ajouter(@RequestBody Commentaire commentaire, @PathVariable Long id_compte, @PathVariable Long id_solution){
        return cs.addcommentaire(commentaire, id_compte, id_solution);
    }

    @PutMapping("/modifier/{id_commentaire}")
    Commentaire modifier(@PathVariable Long id_commentaire, @RequestBody Commentaire commentaire){
        return cs.modifier(id_commentaire, commentaire);
    }
    @DeleteMapping("/supprimer/{id_Commentaire}")
    String supprimer(@PathVariable Long id_Commentaire){
        return cs.supprimer(id_Commentaire);
    }
}
