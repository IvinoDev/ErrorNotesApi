package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Message.ReponseMessage;
import ml.odk.errornotesapi.Model.Etat;
import ml.odk.errornotesapi.Service.EtatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/etat")
public class EtatController {
    private final EtatService etatService;
    @PostMapping("/definir")
    public Object definiretat(@RequestBody Etat etat){
        try {
            return etatService.definiretat(etat);
        }catch (Exception e){
            return ReponseMessage.generateResponse("Cet etat "+etat.getLibelle()+" existe deja", HttpStatus.OK, null);
        }


    }
    /*@GetMapping("/Lire")
    public List<Etat> lire(){
        return etatService.lire();
    }*/
    @PutMapping("/modifier/{id}")
    public Etat modifier(@PathVariable Long id, @RequestBody Etat etat){
        return etatService.modifierEtat(id, etat);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id){
        return etatService.supprimerEtat(id);
    }
}
