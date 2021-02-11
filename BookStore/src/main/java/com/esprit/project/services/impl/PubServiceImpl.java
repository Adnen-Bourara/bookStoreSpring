package com.esprit.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.esprit.project.entities.BookPhysique;
import com.esprit.project.entities.Pub;
import com.esprit.project.repositories.PubRepository;
import com.esprit.project.services.PubService;
@Service
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
	public Pub getById(Long id) {
		return pubRepository.findById(id).get();
	}
	@Override
	public List<Pub> getAllPub() {
		return (List<Pub>) pubRepository.findAll();
	}
	@Override
	public List<Pub> getListPubByCategorieId(Long id) {
		return (List<Pub>) pubRepository.findByCategorie_Id(id);
	}


}
