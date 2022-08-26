package ml.odk.errornotesapi.Repository;


import ml.odk.errornotesapi.Model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long>{
}
