package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte",length = 11)
    private Long id_compte;
    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String profile;


}
