package com.esprit.tn.project1.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosition;

    private Integer classement;
    private Integer nbPoints;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Pilote pilote;


}
