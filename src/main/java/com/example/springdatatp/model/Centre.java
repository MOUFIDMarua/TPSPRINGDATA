package com.example.springdatatp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nomCentre;
    String adresse;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Etudiant> etudiants;
}
