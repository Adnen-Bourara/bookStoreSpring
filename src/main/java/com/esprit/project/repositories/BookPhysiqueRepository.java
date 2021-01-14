package com.esprit.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entities.BookPhysique;

import java.util.List;

@Repository
public interface BookPhysiqueRepository extends CrudRepository<BookPhysique, Long> {

    List <BookPhysique> findByAuteur_Id(Long id);
    List <BookPhysique> findByCategorie_Id(Long id);

}
