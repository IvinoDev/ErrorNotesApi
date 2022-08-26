package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatRepository extends JpaRepository<Etat,Long> {
}
