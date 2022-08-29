package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Message.ReponseMessage;
import ml.odk.errornotesapi.Model.Commentaire;

import ml.odk.errornotesapi.Service.CommentaireService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/commentaire")
public class CommentaireController {
    // cser est le sigle de commentaireService
    private final CommentaireService cser;
    @PostMapping("/creer")
    public Object creercommentaire(@RequestBody Commentaire commentaire){
        try {
            return cser.creercommentaire(commentaire);
        }catch (Exception e){
            return ReponseMessage.generateResponse("Cet commentaire  "+commentaire.getMessage()+" existe deja", HttpStatus.OK, null);
        }


    }
    @GetMapping("/Lire")
    public List<Commentaire> lire(){
        return cser.lire();
    }
    @PutMapping("/modifier/{id}")
    public Commentaire modifier(@PathVariable Long id, @RequestBody Commentaire commentaire){
        return cser.modifier(id, commentaire);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return cser.supprimer(id);
    }
}
