package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@Table(name = "Commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentaire")
    private Long id_commentaire;
    @Column(name = "message")
    private String message;
    private LocalDate date;
    private LocalTime heure;

    // Ancienne disposition au 29
    @ManyToOne
    private Solution solution;

    /*@ManyToOne
    private Compte compte;*/

    //Disposition Amagarai
    @OneToOne
    private Compte compte;

}
