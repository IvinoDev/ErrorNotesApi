package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Commentaire;

public interface CommentaireService {
    //Pour créer un commentaire
    Commentaire creerCommentaire(Commentaire commentaire);
    
    //Pour modifier un commentaire
    Commentaire modifierCommentaire(Commentaire commentaire);

    //Pour supprimer un commentaire
    Commentaire supprimerCommentaire(Commentaire commentaire);
}
