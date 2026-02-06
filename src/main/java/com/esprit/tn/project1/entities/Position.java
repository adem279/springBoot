package com.esprit.tn.project1.entities;
import jakarta.persistence.*;
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosition;

    private Integer classement;
    private Integer nbPoints;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Pilote pilote;

    // getters & setters
}

