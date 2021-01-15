package com.esprit.project.repositories;

import com.esprit.project.entities.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie,Long> {

}
