package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Message.ReponseMessage;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Service.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/compte")
public class CompteController {
    //coservice est le sigle de compteservice
private final CompteService coservice;
@PostMapping("/creeruser")
public Object creeruser(@RequestBody Compte compte){
    try {
        return coservice.creeruser(compte);
    }catch (Exception e){
        return ReponseMessage.generateResponse("Cet compte "+compte.getEmail()+" existe deja", HttpStatus.OK, null);
    }


}
@GetMapping("/Lire")
public List<Compte>lire(){
    return coservice.lire();
}
    @PutMapping("/modifier/{id}")
    public Compte modifier(@PathVariable Long id, @RequestBody Compte compte){
        return coservice.modifier(id, compte);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return coservice.supprimer(id);
    }
}
