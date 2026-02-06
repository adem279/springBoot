package com.esprit.tn.project1.entities;
import jakarta.persistence.*;
import java.util.List;


public class Championnat {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idChampionnat;

        @Enumerated(EnumType.STRING)
        private Categorie categorie;

        private String libelleC;
        private Integer annee;

        @OneToMany(mappedBy = "championnat")
        private List<Course> courses;

        @OneToOne(mappedBy = "championnat", cascade = CascadeType.ALL)
        private DetailChampionnat detailChampionnat;

        // getters & setters
    }


