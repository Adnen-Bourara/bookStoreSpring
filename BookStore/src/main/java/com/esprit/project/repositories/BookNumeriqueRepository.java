package com.esprit.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.esprit.project.entities.BookNumerique;


public interface BookNumeriqueRepository extends CrudRepository<BookNumerique, Long> {

    List <BookNumerique> findByAuteur_Id(Long id);
    List <BookNumerique> findByCategorie_Id(Long id);
}
