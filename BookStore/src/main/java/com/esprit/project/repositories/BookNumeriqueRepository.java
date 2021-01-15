package com.esprit.project.repositories;

import com.esprit.project.entities.BookNumerique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookNumeriqueRepository extends CrudRepository<BookNumerique, Long> {

    List<BookNumerique> findByAuteur_Id(Long id);
    List <BookNumerique> findByCategorie_Id(Long id);
}
