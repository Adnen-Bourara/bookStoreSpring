package com.esprit.project.services;

import java.util.List;

import com.esprit.project.entities.Pub;

public interface PubService {
	Pub getById(Long id);
	List<Pub> getAllPub();
	List<Pub> getListPubByCategorieId(Long id);
    Pub savePub(Pub pub);
    Pub updatePub(Pub pub);
    void deletePub(Long pub);
    
    }
