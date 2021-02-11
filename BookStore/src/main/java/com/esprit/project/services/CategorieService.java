package com.esprit.project.services;

import com.esprit.project.entities.Categorie;

import java.util.List;

public interface CategorieService {

    List<Categorie> getAll();
    Categorie getById(Long id);
}
