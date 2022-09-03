package ml.odk.errornotesapi.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Gestion de commentaire")
@RestController
@Data

@RequestMapping("/commentaire" )
public class CommentaireController {

    //Injection du Service des Commentaires sous le short name "cs" pour pouvoir utiliser les méthodes définies dedans
    @Autowired
    CommentaireService cs;

    //Annotation Swagger pour décrire ce que fait les différents Mapping
    @ApiOperation(value = " Methode pour creer un  commentaire")

    //Renseigner l'id du problème puis celui du compte dans Postman
    @PostMapping("/ajouter/{id_compte}/{id_solution}")
    Commentaire ajouter(@RequestBody Commentaire commentaire, @PathVariable Long id_compte, @PathVariable Long id_solution){
        return cs.addcommentaire(commentaire, id_compte, id_solution);
    }

    @ApiOperation(value = " Methode pour modifier un commentaire")
    @PutMapping("/modifier/{id_commentaire}/{id_compte}")
    Commentaire modifier(@PathVariable Long id_commentaire,@PathVariable Long id_compte, @RequestBody Commentaire commentaire){
        return cs.modifier(id_commentaire,id_compte, commentaire);
    }

    @ApiOperation(value = " Methode pour supprimer un  commentaire")
    @DeleteMapping("/supprimer/{id_Commentaire}")
    String supprimer(@PathVariable Long id_Commentaire){
        return cs.supprimer(id_Commentaire);
    }


    @ApiOperation(value = " Methode pour afficher la liste des commentaires")
    @GetMapping("/liste")
    public List<Commentaire> lister() {
        return cs.lire();
    }

}
