package com.esprit.project.services.impl;

import com.esprit.project.entities.Client;
import com.esprit.project.repositories.ClientRepository;
import com.esprit.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

@Autowired
    ClientRepository clientRepository;
    @Override
    public Client findById(Long id) {

            return clientRepository.findById(id).orElse(null);
        }
    }

