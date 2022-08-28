package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;
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
    @Column(name = "date")
    private String date;

   /* @ManyToOne
    private Solution solution;

    @ManyToOne
    private Compte compte;*/

}
