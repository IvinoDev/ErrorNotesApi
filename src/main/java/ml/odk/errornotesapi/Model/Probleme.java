package ml.odk.errornotesapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "probleme")
public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_probleme")
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    private String titre;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false , length = 30)
    private String technologie;
    //private LocalDate date;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Solution solution;

    @ManyToOne
    private Compte compte;



    /*@JsonIgnore
    @OneToOne
    private Solution solution;*/


}
