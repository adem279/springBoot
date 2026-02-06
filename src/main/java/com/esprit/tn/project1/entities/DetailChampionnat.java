package com.esprit.tn.project1.entities;
import jakarta.persistence.*;
public class DetailChampionnat {
    @Id
    private String code;

    private String description;

    @OneToOne
    @JoinColumn(name = "id_championnat")
    private Championnat championnat;

    // getters & setters
}


