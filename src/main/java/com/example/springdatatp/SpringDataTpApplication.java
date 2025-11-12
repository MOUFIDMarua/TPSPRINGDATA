package com.example.springdatatp;

import com.example.springdatatp.model.Centre;
import com.example.springdatatp.model.Etudiant;
import com.example.springdatatp.enums.Genre;
import com.example.springdatatp.repositories.CentreRepository;
import com.example.springdatatp.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataTpApplication implements CommandLineRunner {

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    CentreRepository centreRepository;

    @Override
    public void run(String... args) throws Exception {

        Centre centre1 = Centre.builder()
                .nomCentre("EMSI Roudani")
                .adresse("380 Bd Brahim Roudani, Maarif, Casablanca")
                .build();

        Centre centre2 = Centre.builder()
                .nomCentre("EMSI Bir Anzarane")
                .adresse("Boulevard Bir Anzarane, Casablanca 20250")
                .build();

        Centre centre3 = Centre.builder()
                .nomCentre("EMSI Moulay Youssef")
                .adresse("Boulevard Moulay Youssef, Casablanca")
                .build();

        Centre centre4 = Centre.builder()
                .nomCentre("EMSI Laymoune")
                .adresse("Quartier Laymoune, Casablanca")
                .build();

        Centre centre5 = Centre.builder()
                .nomCentre("EMSI CFC")
                .adresse("Casablanca Finance City, Casablanca")
                .build();


        Centre savedCentre1 = centreRepository.save(centre1);
        Centre savedCentre2 = centreRepository.save(centre2);
        Centre savedCentre3 = centreRepository.save(centre3);
        Centre savedCentre4 = centreRepository.save(centre4);
        Centre savedCentre5 = centreRepository.save(centre5);

        System.out.println("Centres EMSI créés avec succès !");
        System.out.println("----------------------------------");


        Etudiant et1 = Etudiant.builder()
                .nom("Moufid")
                .prenom("Maroua")
                .genre(Genre.Femme)
                .centre(savedCentre1)
                .build();
        etudiantRepository.save(et1);

        Etudiant et2 = Etudiant.builder()
                .nom("Sebti")
                .prenom("Sara")
                .genre(Genre.Femme)
                .centre(savedCentre2)
                .build();
        etudiantRepository.save(et2);

        Etudiant et3 = Etudiant.builder()
                .nom("Echdeigui")
                .prenom("Khaled")
                .genre(Genre.Homme)
                .centre(savedCentre3)
                .build();
        etudiantRepository.save(et3);

        Etudiant et4 = Etudiant.builder()
                .nom("Hadli")
                .prenom("Abderrahmane")
                .genre(Genre.Homme)
                .centre(savedCentre4)
                .build();
        etudiantRepository.save(et4);

        Etudiant et5 = Etudiant.builder()
                .nom("Nidlehsen")
                .prenom("Soukaina")
                .genre(Genre.Femme)
                .centre(savedCentre5)
                .build();
        etudiantRepository.save(et5);

        Etudiant et6 = Etudiant.builder()
                .nom("Elkelali")
                .prenom("Hiba")
                .genre(Genre.Femme)
                .centre(savedCentre5)
                .build();
        etudiantRepository.save(et6);

        System.out.println("Étudiants créés et associés à leurs centres EMSI respectifs !");
        System.out.println("--------------------------------------------------------------");


        System.out.println(" Liste des centres EMSI enregistrés :");
        centreRepository.findAll().forEach(c ->
                System.out.println("- " + c.getNomCentre() + " | Adresse : " + c.getAdresse())
        );

        System.out.println("--------------------------------------------------------------");


        System.out.println(" Liste des étudiants enregistrés :");
        etudiantRepository.findAll().forEach(e ->
                System.out.println("- " + e.getPrenom() + " " + e.getNom() +
                        " (" + e.getGenre() + ") | Centre : " + e.getCentre().getNomCentre())
        );

        System.out.println("--------------------------------------------------------------");
        System.out.println("✅ Données affichées avec succès !");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataTpApplication.class, args);
    }
}
