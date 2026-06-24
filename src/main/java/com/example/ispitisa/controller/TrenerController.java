package com.example.ispitisa.controller;

import com.example.ispitisa.model.Trener;
import com.example.ispitisa.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treneri")
@CrossOrigin(origins = "http://localhost:3000")
public class TrenerController {
    @Autowired
    private TrenerRepository trenerRepository;

    @GetMapping
    public List<Trener> getAll() {
        return trenerRepository.findAll();
    }

    @PostMapping
    public Trener create(@RequestBody Trener trener) {
        return trenerRepository.save(trener);
    }

    @PutMapping("/{id}")
    public Trener update(@PathVariable Long id, @RequestBody Trener trener) {
        trener.setId(id);
        return trenerRepository.save(trener);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trenerRepository.deleteById(id);
    }
}