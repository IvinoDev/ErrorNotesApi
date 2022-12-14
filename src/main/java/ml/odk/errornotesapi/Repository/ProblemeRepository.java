package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProblemeRepository extends JpaRepository<Probleme,Long> {

    //Requête pour récuperer tous les problèmes contenu dans la table Probleme
    /*
    Puis les filtrer en fonction d'un mot clé (là où il y'a l'opérateur SQL "LIKE" et les Jokers (%) qui délimitent
    la portée de la recherche
    */
    @Modifying
    @Query(value = "SELECT * FROM probleme WHERE probleme.titre LIKE %?1%" +
            " OR probleme.description LIKE %?1%" +
            " OR probleme.technologie LIKE %?1%", nativeQuery = true)

    //Stockage du résultat dans une liste
    List<Probleme> findAll(String mot_cle);


    //Verification de l'existance d'un problème à travers le titre
    Optional<Probleme> findByTitre(String titre);
}
