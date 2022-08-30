package ml.odk.errornotesapi.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte")
    private Long id_compte;
    @Column(name = "nom",length = 25)
    private String nom;
    @Column(name = "prenom",length = 25)
    private String prenom;
    @Column(name = "telephone",length = 30)
    private String phone;
    @Column(name = "email",length = 50, unique = true, nullable = false)
    private String email;
    @Column(name = "password",length = 30, unique = true, nullable = false)
    private String password;
    @Column(name = "profile",length = 25)
    @Enumerated(EnumType.STRING)
    private Type type;




    /*@OneToMany(mappedBy = "compte")
    List<Probleme> problemes;

    @OneToMany(mappedBy = "compte")
    List<Commentaire> commentaires;*/


}
