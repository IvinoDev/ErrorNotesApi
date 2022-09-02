package ml.odk.errornotesapi.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte")
    private Long id_compte;
    @Column(length = 25, nullable = false)
    private String nom;
    @Column(length = 25, nullable = false)
    private String prenom;
    @Column(length = 30, unique = true, nullable = false)
    private String phone;
    @Column(length = 50, unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String password;
    @Column(name = "profil")
    @Enumerated(EnumType.STRING)
    private Type type;




    /*@OneToMany(mappedBy = "compte")
    List<Probleme> problemes;

    @OneToMany(mappedBy = "compte")
    List<Commentaire> commentaires;*/


}
