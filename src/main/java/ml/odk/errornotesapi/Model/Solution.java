package ml.odk.errornotesapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "solution")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solution")
    private Long id_solution;
    @Column(nullable = false,length = 225)
    private String description;
    //@Column(nullable = false ,length = 50)
    private String estimation;
    @Column(nullable = false,length = 150)
    private String ressource;
    @Column(nullable = false,length = 225)
    private String methodologie;
    //private LocalDate date;
    private Date date;



    @OneToOne
    private Probleme problemes;

    @JsonIgnore
    @OneToMany(mappedBy = "solution")
    // Changement en arraylist pour gérer le cas où il n'y aurait pas de commentaires
            // s'il y'a une liste vide, pour éviter null
    List<Commentaire> commentaires = new ArrayList<>();


}
