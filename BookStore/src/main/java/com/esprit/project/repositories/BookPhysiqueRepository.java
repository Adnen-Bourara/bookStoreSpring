package com.esprit.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entities.BookPhysique;

@Repository
public interface BookPhysiqueRepository extends CrudRepository<BookPhysique, Long> {

}
