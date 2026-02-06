package com.esprit.tn.project1.entities;
import jakarta.persistence.*;
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private Float montant;
    private String annee;
    private Boolean archived;

    @ManyToOne
    private Sponsor sponsor;

    @ManyToOne
    private Equipe equipe;

    // getters & setters
}
