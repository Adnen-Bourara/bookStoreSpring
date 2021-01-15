package com.esprit.project.services;

import com.esprit.project.entities.Reclamation;

import java.util.List;

public interface ReclamationService {
    public Reclamation add(Reclamation reclamation);
    public Reclamation findById( Long id);
    public List<Reclamation> findAll();
    public void DeleteById( Long id);
    public Reclamation Update(Reclamation reclamation);
}
