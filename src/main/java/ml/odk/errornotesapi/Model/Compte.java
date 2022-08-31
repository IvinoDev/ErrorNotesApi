package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
    @Column(name = "telephone",length = 15)
    private String phone;
    @Column(name = "email",length = 50)
    private String email;
   /* @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;*/




}
