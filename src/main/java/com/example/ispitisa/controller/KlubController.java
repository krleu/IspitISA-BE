package com.example.ispitisa.controller;


import com.example.ispitisa.model.Klub;
import com.example.ispitisa.repository.KlubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/klubovi")
@CrossOrigin(origins = "http://localhost:3000")
public class KlubController {

    @Autowired
    private KlubRepository klubRepository;

    @GetMapping
    public List<Klub> sviKlubovi() {
        return klubRepository.findAll();
    }

    @PostMapping
    public Klub create(@RequestBody Klub klub) {
        return klubRepository.save(klub);
    }

    @PutMapping("/{id}")
    public Klub update(@PathVariable Long id, @RequestBody Klub klub) {
        klub.setId(id);
        return klubRepository.save(klub);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        klubRepository.deleteById(id);
    }
}
