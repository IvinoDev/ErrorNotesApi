package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "probleme")
public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_probleme")
    private Long id_probleme;
    @Column(name = "titre", length = 50)
    private String titre;
    @Column(name = "description", length = 225)
    private String description;
    @Column(name = "technologie",length = 30)
    private String technologie;
    @Column(name = "etat",length = 30)
    @Enumerated(EnumType.STRING)
    private Etat etat;

    /* @OneToOne
    private Solution solution;

    @ManyToOne
    private Compte compte;*/
}
