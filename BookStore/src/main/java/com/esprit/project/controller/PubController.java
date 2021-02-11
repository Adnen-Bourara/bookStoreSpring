package com.esprit.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.esprit.project.entities.CD;
import com.esprit.project.entities.Client;
import com.esprit.project.entities.Commande;
import com.esprit.project.entities.Pub;
import com.esprit.project.services.BookAudioService;
import com.esprit.project.services.BookNumeriqueService;
import com.esprit.project.services.BookPhysiqueService;
import com.esprit.project.services.CDService;
import com.esprit.project.services.ClientService;
import com.esprit.project.services.MagazineService;
import com.esprit.project.services.PubService;
import com.esprit.project.services.RatingService;

public class PubController {
	
    @Autowired
    private PubService pubservice;
	
    @Autowired
    private RatingService ratingService;

    @Autowired
    private BookAudioService bookAudioService;

    @Autowired
    private BookPhysiqueService bookPhysiqueService;

    @Autowired
    private BookNumeriqueService bookNumeriqueService;

    @Autowired
    private CDService cdService;

    @Autowired
    private MagazineService magazineService;

    @Autowired
    private ClientService clientService;
    
    
    @DeleteMapping("/Client/deletePub/{idPub}")
    public  void deleteComment(@PathVariable("idPub") Long idPub){
        pubservice.deletePub(idPub);
    }
    
    @PostMapping("/addPub/")
    public ResponseEntity<?> addCommentCd(@RequestBody Pub pub)
    {
        pub =  pubservice.savePub(pub);
        return ResponseEntity.status(HttpStatus.FOUND).body(pub);
    }
    @PutMapping("/updatePub")
    public ResponseEntity<?> update(@RequestBody Pub pub) {
        Pub pubUpdated = pubservice.updatePub(pub);
        return ResponseEntity.accepted().body(pubUpdated);
    }
    @GetMapping("/ClientPub/{idClent}")
    public Object pubForMe(@PathVariable("idClent") Long id)
    {
		return id;
    	
    }
}
