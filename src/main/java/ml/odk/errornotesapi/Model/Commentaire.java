package ml.odk.errornotesapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private Long id_commentaire;
    @Column(nullable = false)
    private String message;
    private LocalDate date;
    private LocalTime heure;

    // Ancienne disposition au 29
    //@JsonIgnore //Ajouté le 31
    @ManyToOne
    @JoinColumn(name = "id_solution")
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;


    /*@ManyToOne
    private Compte compte;*/

    //Disposition du 30
    /*@OneToOne
    private Compte compte; */


}
