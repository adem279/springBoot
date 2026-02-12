package com.esprit.tn.project1.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detail_championnat")
public class DetailChampionnat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String code;

    private String description;

    @OneToOne
    @JoinColumn(name = "id_championnat")
    private Championnat championnat;


}
