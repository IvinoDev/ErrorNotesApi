package ml.odk.errornotesapi.Controller;

import ml.odk.errornotesapi.Model.Solution;
import ml.odk.errornotesapi.Repository.SolutionRepository;
import ml.odk.errornotesapi.Service.SolutionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SolutionControllerTest {
    @Autowired
    public SolutionRepository sr;
    @Autowired
    SolutionService ss;
    @Mock
    Solution solution;
    @Test
    void ajouter(){
        Solution s= new Solution();
        s.setId_solution(2L);
        s.setDescription("solution très efficace");
        s.setRessource("J'ai regardée une vidéo sur Sprint boot security");
        s.setMethodologie("Plusieurs étapes complexes à suivre");
        s.setDate(new Date());
        s.setEstimation("Deux heures");
        sr.save(s);
        assertNotNull(sr.findById(2L).get());




    }
}
