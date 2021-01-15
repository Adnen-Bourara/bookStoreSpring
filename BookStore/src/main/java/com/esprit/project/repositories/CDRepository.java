package com.esprit.project.repositories;

import com.esprit.project.entities.CD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CDRepository extends CrudRepository<CD,Long> {

    CD findByTitre(String titre);
}