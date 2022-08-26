package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Long> {
}
