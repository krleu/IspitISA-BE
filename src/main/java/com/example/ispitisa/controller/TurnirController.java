package com.example.ispitisa.controller;

import com.example.ispitisa.model.Turnir;
import com.example.ispitisa.repository.TurnirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turniri")
@CrossOrigin(origins = "http://localhost:3000")

public class TurnirController {
    @Autowired
    private TurnirRepository turnirRepository;

    @GetMapping
    public List<Turnir> getAll() {
        return turnirRepository.findAll();
    }

    @PostMapping
    public Turnir create(@RequestBody Turnir turnir) {
        return turnirRepository.save(turnir);
    }

    @PutMapping("/{id}")
    public Turnir update(@PathVariable Long id, @RequestBody Turnir turnir) {
        turnir.setId(id);
        return turnirRepository.save(turnir);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        turnirRepository.deleteById(id);
    }
}