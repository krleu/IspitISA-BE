package com.example.ispitisa.controller;

import com.example.ispitisa.model.Trener;
import com.example.ispitisa.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partije")
@CrossOrigin(origins = "http://localhost:3000")
public class PartijaController {
    @Autowired
    private TrenerRepository partijaRepository;

    @GetMapping
    public List<Trener> getAll() {
        return partijaRepository.findAll();
    }

    @PostMapping
    public Trener create(@RequestBody Trener trener) {
        return partijaRepository.save(trener);
    }

    @PutMapping("/{id}")
    public Trener update(@PathVariable Long id, @RequestBody Trener trener) {
        trener.setId(id);
        return partijaRepository.save(trener);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partijaRepository.deleteById(id);
    }
}