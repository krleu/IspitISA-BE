package com.example.ispitisa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="treneri")
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String prezime;
}
