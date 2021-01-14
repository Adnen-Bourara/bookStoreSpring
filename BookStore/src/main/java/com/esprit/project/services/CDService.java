package com.esprit.project.services;

import com.esprit.project.entities.CD;

import java.util.List;

public interface CDService {
    List<CD> findAll();
    CD findById(Long id);
   Object findByTitre(String titre);

}
