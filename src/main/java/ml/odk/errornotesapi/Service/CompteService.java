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

    //Création d'un admin
    Compte creerAdmin(Compte compte, Long id);

    //modification des informations d'un user
    Compte modifier(Long id, Compte compte);
    // Afficher la liste des utilisateurs
    List<Compte> lire();
    //Rechercher par mot clé
    //Compte rechercher(Compte compte);
    //Suppression d'un user
    String supprimer(Long id);

    //pour trouver un compte via son mail
    Compte getCompteByEmail(String email);

    Compte getCompteByEmailAndPassword(String email, String password);
}
