package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "solution")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solution")
    private Long id_solution;
    @Column(name = "description",length = 225)
    private String description;
    @Column(name = "estimation",length = 50)
    private String estimation;
    @Column(name = "ressource",length = 150)
    private String ressource;
    @Column(name = "methodologie",length = 225)
    private String methodologie;
    @OneToOne
    @JoinColumn(name = "id_probleme")
    private Probleme probleme;


}
