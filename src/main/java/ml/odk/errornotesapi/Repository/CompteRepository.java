package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    //Ajouté le 29
    //fonction pour retrouver un compte via son email
    public Compte findByEmail(String email);
}
