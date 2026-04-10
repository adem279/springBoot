package com.esprit.tn.project1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "contrat")
@Getter
@Setter
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
