package ml.odk.errornotesapi.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import ml.odk.errornotesapi.Message.ReponseMessage;
import ml.odk.errornotesapi.Model.Commentaire;

import ml.odk.errornotesapi.Service.CommentaireService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "Gestion des problèmes")
@Data
@RequestMapping("/commentaire")
public class CommentaireController {
    // cser est le sigle de commentaireService
    private final CommentaireService cser;
    @ApiOperation(value = "Méthode pour créer un commentaire")
    @PostMapping("/creer")
    public Object creercommentaire(@RequestBody Commentaire commentaire){
        try {
            return cser.creercommentaire(commentaire);
        }catch (Exception e){
            return ReponseMessage.generateResponse("Cet commentaire  "+commentaire.getMessage()+" existe deja", HttpStatus.OK, null);
        }


    }
    @ApiOperation(value = "Méthode pour créer un commentaire")
    @GetMapping("/Lire")
    public List<Commentaire> lire(){
        return cser.lire();
    }
    @ApiOperation(value = "Méthode pour créer un commentaire")
    @PutMapping("/modifier/{id}")
    public Commentaire modifier(@PathVariable Long id, @RequestBody Commentaire commentaire){
        return cser.modifier(id, commentaire);
    }
    @ApiOperation(value = "Méthode pour créer un commentaire")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return cser.supprimer(id);
    }
}
