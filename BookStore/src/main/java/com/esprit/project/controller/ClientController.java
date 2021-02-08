package com.esprit.project.controller;

import com.esprit.project.entities.Client;
import com.esprit.project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/client/addclient")
    public ResponseEntity<?> save(@RequestBody Client client ){

        client =  clientService.save(client);
        return ResponseEntity.status(HttpStatus.FOUND).body(client);

    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody Client client){

        client = clientService.save(client);
        return ResponseEntity.status(HttpStatus.FOUND).body(client);

    }
}