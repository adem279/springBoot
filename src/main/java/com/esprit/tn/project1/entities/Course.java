package com.esprit.tn.project1.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    private String emplacement;
    private LocalDate dateCourse;

    @ManyToOne
    private Championnat championnat;

    @OneToMany(mappedBy = "course")
    private List<Position> positions;

    // getters & setters
}

