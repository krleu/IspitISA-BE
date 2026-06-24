package com.example.ispitisa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "turniri")
public class Turnir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String lokacija;

    @ManyToMany(mappedBy = "turniri")
    private List<Igrac> igraci;
}