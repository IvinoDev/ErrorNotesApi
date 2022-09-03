package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Type;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Service.CompteService;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class CompteServiceImpl implements CompteService {

    //Injection du Repository du compte sous le short name "cr" en vue d'utiliser ses méthodes
    @Autowired
    CompteRepository cr;

    //Appel de la méthode d'encryptage de mot de passe de Spring Security Crypto
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Création d'un compte User simple
    @Override
    public Compte creeruser(Compte compte) {
        //fonction pour préciser que les personnes qui s'incrivent sont des users
        compte.setType(Type.User);
        compte.setPassword(passwordEncoder().encode(compte.getPassword()));
        System.out.println("Creation user simple Ok");
        return cr.save(compte);
    }


    //Création d'un compte Admin (reservée au SuperAdmin)
    @Override
    public Compte creerAdmin(Compte compte, Long id) {
        //pour tout d'abord récupérer le compte qui crée l'admin via son id
        Compte compteSuper = cr.findById(id).get();
        if (compteSuper.getType() == Type.Super) {
            //fonction pour créer des comptes admins
            compte.setType(Type.UserAdmin);
            compte.setPassword(passwordEncoder().encode(compte.getPassword()));
            System.out.println("Creation userAdmin Ok");
            return cr.save(compte);
        } else {
            System.out.println("Action impossible");
            return null;
        }
    }


    //Modification d'un compte avec vérification
    @Override
    public Compte modifier(Long id, Compte compte) {
        Compte compteauth = cr.findById(id).get();
        if (compteauth.getType() == Type.Super || compteauth.getType() == Type.UserAdmin || compteauth.getType() == Type.User) {
            return cr.findById(id)
                    .map(c -> {
                        c.setNom(compte.getNom());
                        c.setPrenom(compte.getPrenom());
                        c.setEmail(compte.getEmail());
                        c.setPhone(compte.getPhone());
                        //Plus necessaire car automatique à la création du compte User
                        //c.setType(compte.getType());
                        return cr.save(c);
                    }).orElseThrow(() -> new RuntimeException("Modification interdite"));
        } else {
            System.out.println(" Nous n'avez pas le droit de faire cette action");
        }
        return null;
    }


    //Nouvelle méthode de suppression qui prend en compte des vérifications
    @Override
    public String supprimer(Long id_compte, Long id_compteauth) {
        Compte compteauth = cr.findById(id_compte).get();
        if (compteauth.getType() == Type.Super || compteauth.getType() == Type.UserAdmin) {
            cr.deleteById(id_compte);
            return "Compte supprimé avec succès";
        } else {
            return "Vous n'avez pas le droit d'effectuer cette action";
        }
    }


    //Pour obtenir / rechercher un compte uniquement via son mail
    @Override
    public Compte getCompteByEmail(String email) {
        return cr.findByEmail(email);
    }


    //Pour obtenir / rechercher un compte via son mail et son mdp, utillisée surtout pour notre SuperAdmin et le login
    @Override
    public Compte getCompteByEmailAndPassword(String email, String password) {
        Compte compte = cr.findByEmail(email);
        if (compte != null) {
            if (passwordEncoder().matches(password, compte.getPassword())) {
                return compte;
            }
        }
        return null;
    }



    //ANCIENNE METHODE PAS IMPLEMENTEE
    /* @Override
    public Compte connecter(Compte compte) {
        return null;
    }


    @Override
    public Compte deconnecter(Compte compte) {
        return null;
    } */


    //METHODE DE SUPPRESSION OBSELETE
   /* @Override
    public String supprimer(Long id, Compte compte) {

        if (compte.getType() == Type.Super || compte.getType() == Type.UserAdmin) {
            cr.deleteById(id);
            return "Compte supprimé avec succès";
        } else {
            return "Vous n'avez pas ce droit";
        }
    } */


      /*@Override
    public List<Compte> lire(Long id) {
        Compte compteafficher = cr.findById(id).get();
        if (compteafficher.getType() == Type.Super || compteafficher.getType() == Type.UserAdmin) {
            return cr.findAll();
        }
        return null;

    }*/


    /*@Override
    public Compte rechercher(Compte compte) {

    }*/

}