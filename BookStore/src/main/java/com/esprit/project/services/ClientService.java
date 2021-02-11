package com.esprit.project.services;

import com.esprit.project.entities.Client;
import com.esprit.project.entities.Commande;

public interface ClientService {
    public Client findById(Long id);
}
