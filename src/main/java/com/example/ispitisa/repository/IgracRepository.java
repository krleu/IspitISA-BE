package com.example.ispitisa.repository;

import com.example.ispitisa.model.Igrac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long> {}
