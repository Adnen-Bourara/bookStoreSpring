package com.esprit.project.repositories;

import com.esprit.project.entities.Categorie;

import java.util.List;

public interface CustomizedCategorieRepository {
    List<Categorie> search(String terms, int limit, int offset);
}
