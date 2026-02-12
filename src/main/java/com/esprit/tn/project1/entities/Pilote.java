package com.esprit.tn.project1.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pilote")
public class Pilote implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
