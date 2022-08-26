package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
