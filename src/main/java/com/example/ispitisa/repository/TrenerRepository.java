package com.example.ispitisa.repository;

import com.example.ispitisa.model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrenerRepository extends JpaRepository<Trener, Long> {}