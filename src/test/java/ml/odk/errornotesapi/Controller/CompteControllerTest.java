package ml.odk.errornotesapi.Controller;

import ml.odk.errornotesapi.Model.Commentaire;
import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Type;
import ml.odk.errornotesapi.Repository.CompteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompteControllerTest {
    CompteRepository cr;

    @Mock
    Compte compte;

    @Test
    void login(

    ) {
    }

    @Test
    void testLogin() {
    }

    @Test
    void creer() {
        Compte compte =new Compte();
        compte.setId_compte(4L);
        compte.setNom("SYLLA");
        compte.setPrenom("Nene");
        compte.setPhone("+223789456432");
        compte.setEmail("nenesylla7766@gmail.com");
        compte.setPassword("nene@2022");
        compte.setType(Type.User);
        cr.save(compte);
        assertNotNull(cr.findById(4L).get());

    }

    @Test
    void creerAdmin() {
        Compte compte =new Compte();
        compte.setId_compte(5L);
        compte.setNom("DIALLO");
        compte.setPrenom("Kaou");
        compte.setPhone("+22376299288");
        compte.setEmail("hamadoun66@gmail.com");
        compte.setPassword("!Kaou@2022");
        compte.setType(Type.UserAdmin);
        cr.save(compte);
        assertNotNull(cr.findById(5L).get());

    }

    @Test
    void modifier() {
        Compte compte =new Compte();
        compte.setId_compte(4L);
        compte.setNom("SYLLA");
        compte.setPrenom("Nene");
        compte.setPhone("+223984345456");
        compte.setEmail("nenesylla7766@gmail.com");
        compte.setPassword("@nene@jolie22");
        compte.setType(Type.User);
        cr.save(compte);

    }

    @Test
    void supprimer() {
        Compte compte =new Compte();
        compte.setId_compte(5L);
        compte.setNom("DIALLO");
        compte.setPrenom("Kaou");
        compte.setPhone("+22376299288");
        compte.setEmail("hamadoun66@gmail.com");
        compte.setPassword("!Kaou@2022");
        compte.setType(Type.UserAdmin);
        Compte compte1 = cr.save(compte);
       cr.deleteById(compte1.getId_compte());

    }

}