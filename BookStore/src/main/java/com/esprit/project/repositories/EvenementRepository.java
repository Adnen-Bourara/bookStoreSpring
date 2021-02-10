package com.esprit.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.esprit.project.entities.Evenement;

public interface EvenementRepository extends CrudRepository<Evenement, Long> {

}
