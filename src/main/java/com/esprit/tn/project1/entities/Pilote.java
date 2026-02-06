package com.esprit.tn.project1.entities;
import jakarta.persistence.*;
import java.util.List;
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilote;

    private String libelleP;
    private Integer nbPointsTotal;
    private Integer classementGeneral;

    @ManyToOne
    private Equipe equipe;

    @OneToMany(mappedBy = "pilote")
    private List<Position> positions;

    // getters & setters
}

