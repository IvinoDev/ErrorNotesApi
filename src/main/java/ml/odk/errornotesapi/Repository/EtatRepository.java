package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepository extends JpaRepository<Etat,Long> {
}
