package com.esprit.tn.project1.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "championnat")
public class Championnat implements Serializable {

        private static final long serialVersionUID = 1L;

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


}
