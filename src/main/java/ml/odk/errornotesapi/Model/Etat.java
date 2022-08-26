package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etat")
    private Long id_etat;
    private String libelle;

}
