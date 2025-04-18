package org.bank.repository;

import org.bank.entity.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
}
