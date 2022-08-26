package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_probleme")
    private Long id_probleme;
    private  String titre;
    private String description;
    private String technologie;

}
