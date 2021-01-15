package com.esprit.project.repositories;

import com.esprit.project.entities.Evenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement, Long> {

}
