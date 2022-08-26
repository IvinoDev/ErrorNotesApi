package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemeRepository extends JpaRepository<Probleme,Long> {
}
