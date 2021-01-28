package com.esprit.project.controller;

import com.esprit.project.entities.Client;
import com.esprit.project.exceptions.SavingIdException;
import com.esprit.project.services.CDService;
import com.esprit.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client/")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("addclient")
    public ResponseEntity<?> save(@RequestBody Client client ){


        if(client.getId() == null){

            Optional<Client> client1 = Optional.of(clientService.save(client));
            return ResponseEntity.created(null).body(client1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody Client client){
        if(client.getId() != null){
            Client client1 = clientService.save(client);
            return ResponseEntity.accepted().body(client1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }
}
