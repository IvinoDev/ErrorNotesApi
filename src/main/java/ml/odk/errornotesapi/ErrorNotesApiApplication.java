package ml.odk.errornotesapi;

import ml.odk.errornotesapi.Model.Compte;
import ml.odk.errornotesapi.Model.Type;
import ml.odk.errornotesapi.Repository.CompteRepository;
import ml.odk.errornotesapi.Service.CompteService;
import ml.odk.errornotesapi.ServiceImplementation.CompteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ErrorNotesApiApplication implements CommandLineRunner {
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    CompteServiceImpl compteService;
    public static void main(String[] args) {
        SpringApplication.run(ErrorNotesApiApplication.class, args);
    }

    public void run(String... args) throws Exception {
        //Compte compte = compteRepository.findByEmailAndPassword("fkaloga@gmail.com", "Kaloga123");
        //if (compte == null) {

        Compte superAdmin = new Compte();
        superAdmin.setId_compte(1L);
        superAdmin.setNom("Kaloga");
        superAdmin.setPrenom("Fatoumata");
        superAdmin.setPhone("+33417895467");
        superAdmin.setEmail("fkaloga@gmail.com");
        superAdmin.setPassword(compteService.passwordEncoder().encode("Kaloga123"));
        superAdmin.setType(Type.Super);
        compteRepository.save(superAdmin);
        //}
        System.out.println("creation Super OK");


    }
}
