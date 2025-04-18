package org.bank.service;


import org.bank.entity.Partenaire;
import org.bank.repository.PartenaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartenaireService {

    private final PartenaireRepository repository;

    public PartenaireService(PartenaireRepository repository) {
        this.repository = repository;
    }

    public List<Partenaire> findAll() {
        return repository.findAll();
    }

    public Partenaire save(Partenaire partenaire) {
        return repository.save(partenaire);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

