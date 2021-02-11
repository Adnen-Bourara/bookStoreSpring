package com.esprit.project.repositories;

import com.esprit.project.entities.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long>, CustomizedCategorieRepository {

}

