package com.example.ispitisa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "igraci")
public class Igrac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String prezime;
    private Integer rejting;

    @ManyToOne
    @JoinColumn(name = "klub_id")
    private Klub klub;

    @ManyToMany
    @JoinTable(
            name = "igrac_turnir" ,
            joinColumns = @JoinColumn(name = "igrac_id"),
            inverseJoinColumns = @JoinColumn(name = "turnir_id")
    )
    private List<Turnir> turniri;

}
