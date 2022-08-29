package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Message.ReponseMessage;

import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/probleme")
public class ProblemeController {
    @Autowired
    ProblemeService ps;

    @GetMapping("/recherche/{mot_cle}")
        Object recherche(@PathVariable String mot_cle){
            return ps.recherche(mot_cle);
    }
   @PostMapping("/creer")
   public Object creer(@RequestBody Probleme probleme){
       try {
           return ps.creerprobleme(probleme);
       }catch (Exception e){
           return ReponseMessage.generateResponse("Cet compte "+probleme.getTitre()+" existe deja", HttpStatus.OK, null);
       }


   }
    @GetMapping("/Lire")
    public List<Probleme> lire(){
        return ps.lire();
    }
    @PutMapping("/modifier/{id}")
    public Probleme modifier(@PathVariable Long id, @RequestBody Probleme probleme){
        return ps.modifier(id, probleme);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return ps.supprimer(id);
    }


}
