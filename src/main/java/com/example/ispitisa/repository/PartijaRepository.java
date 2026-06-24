package com.example.ispitisa.repository;

import com.example.ispitisa.model.Partija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartijaRepository extends JpaRepository<Partija,Long> {
}
