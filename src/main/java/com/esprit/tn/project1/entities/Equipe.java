package com.esprit.tn.project1.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "equipe")
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    private String libelle;
    private Integer nbPointsTotal;
    private Integer classementGeneral;

    @OneToMany(mappedBy = "equipe")
    private List<Pilote> pilotes;

    @OneToMany(mappedBy = "equipe")
    private List<Contrat> contrats;

}
