package com.esprit.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.esprit.project.entities.Pub;
import com.esprit.project.repositories.PubRepository;
import com.esprit.project.services.PubService;

public class PubServiceImpl implements PubService {
    @Autowired
    private PubRepository pubRepository;
	@Override
	public Pub savePub(Pub pub) {
		return pubRepository.save(pub);
	}
	@Override
	public Pub updatePub(Pub pub) {
		return pubRepository.save(pub);
	}
	@Override
	public void deletePub(Long id) {
        try {
        	pubRepository.deleteById(id);
        }
     catch(
    EmptyResultDataAccessException e)

    {
        System.out.println("doesn't exist");
    }
		
	}
	@Override
	public Pub findByClient_Id(Long idClient) {
		return null;
	}


}
