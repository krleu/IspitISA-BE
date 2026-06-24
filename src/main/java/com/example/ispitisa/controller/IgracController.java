package com.example.ispitisa.controller;

import com.example.ispitisa.model.Igrac;
import com.example.ispitisa.repository.IgracRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/igraci")
@CrossOrigin(origins = "http://localhost:3000")
public class IgracController {

    @Autowired
    private IgracRepository igracRepository;

    @GetMapping
    public List<Igrac> sviIgraci(){
        return igracRepository.findAll();
    }

    @PostMapping
    public Igrac create(@RequestBody Igrac igrac) {
        return igracRepository.save(igrac);
    }

    @PutMapping("/{id}")
    public Igrac update(@PathVariable Long id,@RequestBody Igrac igrac){
        igrac.setId(id);
        return igracRepository.save(igrac);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        igracRepository.deleteById(id);
    }
}
