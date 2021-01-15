package com.esprit.project.services.impl;

import com.esprit.project.entities.Commande;
import com.esprit.project.repositories.CommandeRepository;
import com.esprit.project.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeServiceImpl implements CommandeService{

final CommandeRepository commandeRepository;

    @Autowired

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Commande add(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande findById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    @Override
    public void DeleteById(Long id) {
     commandeRepository.deleteById(id);
    }
    @Override
    public Commande Update(Commande commande){
        return commandeRepository.save(commande);
    }
}
