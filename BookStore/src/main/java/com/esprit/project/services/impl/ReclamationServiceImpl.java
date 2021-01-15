package com.esprit.project.services.impl;

import com.esprit.project.entities.Reclamation;
import com.esprit.project.repositories.ReclamationRepository;
import com.esprit.project.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationServiceImpl implements ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public Reclamation add(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }


    @Override
    public Reclamation findById(Long id) {
        return reclamationRepository.findById(id).get();
    }

    @Override
    public List<Reclamation> findAll() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    @Override
    public void DeleteById(Long id) {
        reclamationRepository.deleteById(id);
    }
    @Override
    public Reclamation Update(Reclamation reclamation){
        return reclamationRepository.save(reclamation);
    }

}
