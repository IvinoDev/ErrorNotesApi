package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Compte creeruser(Compte compte) {
        return cr.save(compte);
    }

    @Override
    public Compte modifier(Long id, Compte compte) {
        return cr.findById(id)
                .map(c->{
                    c.setNom(compte.getNom());
                    c.setPrenom(compte.getPrenom());
                    c.setEmail(compte.getEmail());
                    c.setPhone(compte.getPhone());
                    c.setType(compte.getType());
                    return cr.save(c);

                }).orElseThrow(() -> new RuntimeException("Modification interdite"));
    }


    @Override
    public List<Compte> lire() {
        return null;
    }

    @Override
    public Compte rechercher(Compte compte) {
        return null;
    }

    @Override
    public String supprimer(Long id) {
        cr.deleteById(id);
        return "Compte supprimé avec succès";
    }

    @Override
    public Compte getCompteByEmail(String email) {
        return cr.findByEmail(email);
    }


}
