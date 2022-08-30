package ml.odk.errornotesapi.Controller;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Probleme;
import ml.odk.errornotesapi.Model.Type;
import ml.odk.errornotesapi.Service.CompteService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Data
@RequestMapping("/utilisateur")
public class CompteController {
    @Autowired
    CompteService cs;

    /**
     * Connexion utilisateur
     */
    @PostMapping("/connexion/{email}/{password}")
    public String login(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
        //String email = request.getParameter("email");
        //String password = request.getParameter("password");
        System.out.println(email);
        System.out.println(password);
        Compte compte = cs.getCompteByEmail(email);

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || compte == null) {
            return "e-mail ou mot de passe incorrect.";
        }

        //HttpSession session = request.getSession();
        //session.setAttribute("compte", compte);
        if (compte.getPassword().equals(password)) {
            if (compte.getType().equals(Type.UserAdmin)) {
                return "Bienvenue cher Admin";
            } else {
                return "Bienvenue cher User";
            }
        } else {

            //model.put("msg", "Nom d'utilisateur ou mot de passe incorrect.");
            return "Connexion impossible";
        }
    }

    @PostMapping("/creer")
    public Compte creer (@RequestBody Compte compte) {
        return cs.creeruser(compte);
    }

    @PutMapping("/modifier/{id}")
    public Object modifier (@RequestBody Compte compte, @PathVariable(value = "id") Long id) {
        /*Compte compt = new Compte();
        if (compt.getType() == Type.UserAdmin){*/
            return cs.modifier(id, compte);
        /*}
        return "Action impossible";*/
    }
    //Verification de l'identité de l'user pour effectuer la suppression
    @DeleteMapping("/supprimer/{id}")
    public String supprimer (@PathVariable Long id) {
        /*Compte compt = new Compte();
        if (compt.getType() == Type.UserAdmin){*/
            return cs.supprimer(id);
        /*}
       return "Action impossible";*/
    }




   /* Compte compte = CompteService.getByEmail(email);
    HttpSession session = request.getSession();
    session.setAttribute("compte", compte);
    if(compte.getPassword().equals(password)){
        if(compte.getType().equals("UserAdmin")){
            return "Bienvenue cher Admin";
        }else {
            return "Bienvenue cher utilisateur";
        } */
 }