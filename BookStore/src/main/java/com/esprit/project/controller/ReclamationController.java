package com.esprit.project.controller;

import com.esprit.project.entities.Commande;
import com.esprit.project.entities.Reclamation;
import com.esprit.project.services.ReclamationService;
import com.esprit.project.services.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;

    @Autowired
    EmailService emailService;

    @GetMapping("/Reclamation")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(reclamationService.findAll());
    }
    @PostMapping("/Reclamation")
    public ResponseEntity<?> add(@RequestBody Reclamation r){
        Optional<Reclamation> reclamation1=   Optional.of(reclamationService.add(r));
        return ResponseEntity.created(null).body(reclamation1);
    }
    @PutMapping("/Reclamation")
    public ResponseEntity<?> update(@RequestBody Reclamation reclamation ){

        Reclamation reclamation1 = reclamationService.Update(reclamation);
        return ResponseEntity.accepted().body(reclamation1);

    }
    @DeleteMapping("/Reclamation/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        reclamationService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/testMail")
    public Object testSendiMail()
    {
        emailService.sendMail("Dorra.bouzidi@esprit.tn","test mail","hello dorra it's a test");
        return ResponseEntity.accepted().body("email sent");
    }

}
