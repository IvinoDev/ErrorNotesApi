package ml.odk.errornotesapi.Repository;

import ml.odk.errornotesapi.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======

import java.util.List;
>>>>>>> bb81a1086c4219a6001287d957821d8d025188f9

import java.util.List;

@Repository
public interface ProblemeRepository extends JpaRepository<Probleme,Long> {
<<<<<<< HEAD
    //Requête pour récuperer tous les problèmes contenu dans la table Probleme
    //Puis les filtrer en fonction d'un mot clé (là où il y'a LIKE puis les signes
    @Query("SELECT * FROM probleme WHERE probleme.titre LIKE %?1%", nativeQuery = true)
    //Liste qui stocke tous les problemes et qui a le mot clé en paramètre
    public List<Probleme> problemes(String mot_cle);
=======
    @Query(value = "SELECT * FROM probleme WHERE probleme.titre LIKE %?1%", nativeQuery = true)

    List<Probleme> findAll(String mot_cle);
>>>>>>> bb81a1086c4219a6001287d957821d8d025188f9
}
