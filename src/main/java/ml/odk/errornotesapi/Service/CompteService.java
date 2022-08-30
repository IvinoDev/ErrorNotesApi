package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Compte;

import java.util.List;

public interface CompteService {


    //connexion à un compte
    Compte connecter(Compte compte);
    //deconnexion à un compte
    Compte deconnecter(Compte compte);

    //Création d'un utilisateur
    Compte creeruser(Compte compte);
    //modification des informations d'un user
    Compte modifier(Long id, Compte compte);
    // Afficher la liste des utilisateurs
    List<Compte> lire();
    //Rechercher par mot clé
    //Compte rechercher(Compte compte);
    //Suppression d'un user
    String supprimer(Long id);


    Compte getCompteByEmail(String email);
}
