package com.esprit.project.repositories;

import com.esprit.project.entities.Reclamation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {
}
