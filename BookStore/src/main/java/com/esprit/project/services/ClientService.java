package com.esprit.project.services;

import com.esprit.project.entities.Client;

public interface ClientService {
    Client save(Client client);
    Client getById(Long id);

}
