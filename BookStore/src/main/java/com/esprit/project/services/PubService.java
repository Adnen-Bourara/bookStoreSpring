package com.esprit.project.services;

import com.esprit.project.entities.Pub;

public interface PubService {
    Pub savePub(Pub pub);
    Pub updatePub(Pub pub);
    void deletePub(Long pub);
    
    Pub findByClient_Id(Long idClient);
}
