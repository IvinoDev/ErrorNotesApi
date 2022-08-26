package ml.odk.errornotesapi.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solution")
    private Long id_solution;
    private String description;
    private String estimation;
    private  String ressource;
    private  String methodologie;


}
