package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemeRepository extends JpaRepository<Probleme,Long> {
    @Query(value = "SELECT * FROM probleme WHERE probleme.titre LIKE %?1%", nativeQuery = true)

    List<Probleme> findAll(String mot_cle);
}
