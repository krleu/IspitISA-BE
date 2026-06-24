package com.example.ispitisa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "partije")
public class Partija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rezultat;
    private String datum;
}