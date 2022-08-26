package ml.odk.errornotesapi.ServiceImplementation;

import lombok.Data;
import ml.odk.errornotesapi.Model.Etat;
import ml.odk.errornotesapi.Repository.EtatRepository;
import ml.odk.errornotesapi.Service.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class EtatServiceImpl implements EtatService {
    @Autowired
    // er est le sigle d' etatRepository
    private  final EtatRepository er;
    @Override
    public Etat definiretat(Etat etat) {

        return er.save(etat);
    }

    @Override
    public Etat modifierEtat(Long id, Etat etat) {
        return er.findById(id)
                .map(e->{
                    e.setLibelle(etat.getLibelle());
                    return er.save(e);

                }).orElseThrow(() -> new RuntimeException("Modifcation de l'etat interdite"));
    }

    @Override
    public String supprimerEtat(Long id) {
        er.deleteById(id);
        return "Etat supprimée avec Succès";
    }
}
