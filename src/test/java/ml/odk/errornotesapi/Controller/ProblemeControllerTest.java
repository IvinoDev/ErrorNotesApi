package ml.odk.errornotesapi.Controller;

import ml.odk.errornotesapi.Model.*;
import ml.odk.errornotesapi.Repository.ProblemeRepository;
import ml.odk.errornotesapi.Service.ProblemeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProblemeControllerTest {

    @Autowired
    public ProblemeRepository pr;

    @Autowired
    ProblemeService ps;

    @Mock
    Solution solution;

    @Mock
    Compte compte;


    @Test
    void ajouter() {
        Probleme p = new Probleme();
        p.setId(1L);
        p.setTitre("Test unitaire en Spring Boot");
        p.setDescription("C'est super désorientant et pas forcément plus pratique que Postman ou Swagger");
        p.setTechnologie("Spring Boot");
        p.setEtat(Etat.initie);
        p.setDate(new Date());
        pr.save(p);
        assertNotNull(pr.findById(1L).get());
    }


}