package com.esprit.tn.project1.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contrat")
public class Contrat implements Serializable {

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


}
