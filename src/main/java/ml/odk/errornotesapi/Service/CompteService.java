package ml.odk.errornotesapi.Service;

import ml.odk.errornotesapi.Model.Compte;

import java.util.List;

public interface CompteService {

    //Création d'un utilisateur
    Compte creeruser(Compte compte);

    //Création d'un admin (méthode reservée au SuperAdmin)
    Compte creerAdmin(Compte compte, Long id);

    //modification des informations d'un user
    Compte modifier(Long id, Compte compte);

    //Suppression d'un user
    String supprimer(Long id_compte, Long id_compteauth);

    //pour trouver un compte via son mail et password
    Compte getCompteByEmailAndPassword(String email, String password);

    //pour trouver un compte uniquement via son mail
    Compte getCompteByEmail(String email);


    /*
    //connexion (méthode obselète, voir controlleur pour la nouvelle)
    Compte connecter(Compte compte);
    //déconnexion (méthode obselète, voir controlleur pour la nouvelle)
    Compte deconnecter(Compte compte); */


    /*Afficher la liste des utilisateurs
    List<Compte> lire(Long id);
    Rechercher par mot clé
    Compte rechercher(Compte compte);*/
}
