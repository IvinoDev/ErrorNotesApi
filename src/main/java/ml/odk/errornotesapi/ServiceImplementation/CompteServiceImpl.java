package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Service.CompteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class CompteServiceImpl implements CompteService {
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
        return null;
    }

    @Override
    public Compte modifier(Compte compte) {
        return null;
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
    public Compte supprimer(Compte compte) {
        return null;
    }
}
