package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/probleme")
public class ProblemeController {
    @Autowired
    ProblemeService ps;

   /* @GetMapping("/recherche/{mot_cle}"){
        Object search(@PathVariable String mot_cle){
            return ps.recherche(mot_cle);
        }
    }*/


}
