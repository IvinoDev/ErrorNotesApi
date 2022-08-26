package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentaire")
    private Long id_commentaire;
    private String message;
    private Date date;

}
