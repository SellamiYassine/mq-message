package org.bank.controller;

import org.bank.entity.Partenaire;
import org.bank.service.PartenaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/partenaires")
public class PartenaireController {

    private final PartenaireService service;

    public PartenaireController(PartenaireService service) {
        this.service = service;
    }

    @GetMapping
    public List<Partenaire> getAllPartenaires() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Partenaire> addPartenaire(@RequestBody @Valid Partenaire partenaire) {
        Partenaire saved = service.save(partenaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartenaire(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

