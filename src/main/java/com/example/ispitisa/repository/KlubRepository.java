package com.example.ispitisa.repository;

import com.example.ispitisa.model.Klub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlubRepository extends JpaRepository<Klub, Long> {
}
