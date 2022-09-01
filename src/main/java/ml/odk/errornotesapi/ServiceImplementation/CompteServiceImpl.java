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
    @Autowired
    CompteRepository cr;

    @Override
    public Compte connecter(Compte compte) {
        return null;
    }

    @Override
    public Compte deconnecter(Compte compte) {
        return null;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public Compte creeruser(Compte compte) {
        //fonction pour préciser que les personnes qui s'incrivent sont des users
        compte.setType(Type.User);
        compte.setPassword(passwordEncoder().encode(compte.getPassword()));
        return cr.save(compte);
    }

    @Override
    public Compte creerAdmin(Compte compte, Long id) {
        //pour tout d'abord récupérer le compte qui crée l'admin via son id
        Compte compteSuper = cr.findById(id).get();
        if (compteSuper.getType() == Type.Super){
            //fonction pour créer des comptes admins
            compte.setType(Type.UserAdmin);
            System.out.println("Creation userAdmin Ok");
            return cr.save(compte);
        } else {
            System.out.println("Action impossible");
            return null;
        }
    }
    @Override
    public Compte modifier(Long id, Compte compte) {
        Compte compteauth =cr.findById(id).get();
        if (compteauth.getType() == Type.Super || compteauth.getType()==Type.UserAdmin || compteauth.getType()==Type.User){
        return cr.findById(id)
                .map(c->{
                    c.setNom(compte.getNom());
                    c.setPrenom(compte.getPrenom());
                    c.setEmail(compte.getEmail());
                    c.setPhone(compte.getPhone());

                    return cr.save(c);
                }).orElseThrow(() -> new RuntimeException("Modification interdite"));
        } else {
            System.out.println(" Nous n'avez pas le droit de faire cette action");
        }
        return null;
    }


    @Override
    public List<Compte> lire(Long id) {
        Compte compteafficher =cr.findById(id).get();
        if (compteafficher.getType() == Type.Super || compteafficher.getType()==Type.UserAdmin){
            return cr.findAll();
        }
        return null;

    }



    /*@Override
    public Compte rechercher(Compte compte) {

    }*/


    //Ancien deletepb
    @Override
    public String supprimer(Long id) {
        cr.deleteById(id);
        return "Compte supprimé avec succès";
    }

    //nv delete pb
   /* @Override
    public String supprimer(Long id, Compte compte) {

        if (compte.getType() == Type.Super || compte.getType() == Type.UserAdmin) {
            cr.deleteById(id);
            return "Compte supprimé avec succès";
        } else {
            return "Vous n'avez pas ce droit";
        }
    } */
    @Override
    public Compte getCompteByEmail(String email) {
        return cr.findByEmail(email);
    }

    @Override
    public Compte getCompteByEmailAndPassword(String email, String password) {
        return cr.findByEmailAndPassword(email, passwordEncoder().encode(password));
    }
}
