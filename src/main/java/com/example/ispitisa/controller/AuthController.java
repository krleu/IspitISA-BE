package com.example.ispitisa.controller;

import com.example.ispitisa.config.JwtUtils;
import com.example.ispitisa.model.Korisnik;
import com.example.ispitisa.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Korisnik korisnik) {
        if (korisnikRepository.findByUsername(korisnik.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Korisničko ime već postoji!"));
        }

        if (korisnik.getRole() == null || korisnik.getRole().isBlank()) {
            korisnik.setRole("USER");
        }

        korisnik.setPassword(passwordEncoder.encode(korisnik.getPassword()));
        korisnikRepository.save(korisnik);
        return ResponseEntity.ok(Map.of("message", "Korisnik registrovan!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Korisnik loginRequest) {
        var userOpt = korisnikRepository.findByUsername(loginRequest.getUsername());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Korisnik nije pronađen"));
        }

        Korisnik user = userOpt.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Pogrešna lozinka!"));
        }

        String token = jwtUtils.generateToken(user.getUsername());
        return ResponseEntity.ok(Map.of("token", token));
    }
}