package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Service.CompteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class CompteServiceImpl implements CompteService {
    // cpr est le sigle de compterepository
    private  final CompteRepository cpr;
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
        return cpr.save(compte);
    }

    @Override
    public Compte modifier(Long id, Compte compte) {
        return cpr.findById(id)
                .map(cp->{
                    cp.setNom(compte.getNom());
                    cp.setPrenom(compte.getPrenom());
                    cp.setPhone(compte.getPhone());
                    cp.setEmail(compte.getEmail());
                    cp.setProfile(compte.getProfile());
                    return cpr.save(cp);

                }).orElseThrow(() -> new RuntimeException("Désole, compte non trouvé"));
    }



    @Override
    public List<Compte> lire() {
        return cpr.findAll();
    }

    @Override
    public Compte rechercher(Compte compte) {
        return null;
    }

    @Override
    public String supprimer(Long id) {
        cpr.deleteById(id);
        return "Compte Supprimé avec succès";
    }

  


}
