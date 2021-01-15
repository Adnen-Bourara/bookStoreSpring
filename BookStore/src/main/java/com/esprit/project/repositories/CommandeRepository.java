package com.esprit.project.repositories;

import com.esprit.project.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {


}
