package com.example.ispitisa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "klubovi")
public class Klub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String grad;
}
