package com.esprit.project.controller;

import com.esprit.project.entities.Commande;
import com.esprit.project.entities.Reclamation;
import com.esprit.project.services.ReclamationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/commande")
public class ReclamationController {
    final ReclamationService reclamationService;

    public ReclamationController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(reclamationService.findAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Reclamation r){
        Optional<Reclamation> reclamation1=   Optional.of(reclamationService.add(r));
        return ResponseEntity.created(null).body(reclamation1);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Reclamation reclamation ){

        Reclamation reclamation1 = reclamationService.Update(reclamation);
        return ResponseEntity.accepted().body(reclamation1);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        reclamationService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }


}
