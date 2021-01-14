package com.esprit.project.services.impl;


import com.esprit.project.entities.Client;
import com.esprit.project.repositories.ClientRepository;
import com.esprit.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
final ClientRepository clrep;
@Autowired
public ClientServiceImpl(ClientRepository clrep){
    this.clrep=clrep;
}
    @Override
    public Client save(Client client) {
        return clrep.save(client);
    }
}
