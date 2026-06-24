package com.example.ispitisa.controller;

import com.example.ispitisa.model.Partija;
import com.example.ispitisa.repository.PartijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partije")
@CrossOrigin(origins = "http://localhost:3000")
public class PartijaController {

    @Autowired
    private PartijaRepository partijaRepository;

    @GetMapping
    public List<Partija> svePartije() {
        return partijaRepository.findAll();
    }

    @PostMapping
    public Partija create(@RequestBody Partija partija) {
        return partijaRepository.save(partija);
    }

    @PutMapping("/{id}")
    public Partija update(@PathVariable Long id, @RequestBody Partija partija) {
        partija.setId(id);
        return partijaRepository.save(partija);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partijaRepository.deleteById(id);
    }
}