package com.esprit.project.controller;

import com.esprit.project.entities.Commande;
import com.esprit.project.services.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/commande")
public class CommandeController {
    final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(commandeService.findAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Commande c){
        Optional<Commande> commande1=   Optional.of(commandeService.add(c));
        return ResponseEntity.created(null).body(commande1);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Commande commande ){

        Commande commande1 = commandeService.Update(commande);
        return ResponseEntity.accepted().body(commande1);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        commandeService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }


}
