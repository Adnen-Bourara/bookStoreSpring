package com.esprit.project.controller;

import com.esprit.project.entities.*;
import com.esprit.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

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



    @PostMapping ("/Client/{idClient}/addRating/bookA/{idBookA}")
    public Object addRatingBookAudio(@RequestBody Rating rating,@PathVariable("idClient") Long idClient, @PathVariable("idBookA") Long idBookA)
    {
        BookAudio ba = bookAudioService.getById(idBookA);
        Client client = clientService.getByID(idClient);
        rating.setBookA(ba);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }




    @PostMapping("/Client/{idClient}/addRating/bookP/{idBookP}")
    public Object addRatingBookPhysique(@RequestBody Rating rating, @PathVariable("idClient") Long idClient, @PathVariable("idBookP") Long idBookP)
    {
        BookPhysique bp = bookPhysiqueService.getById(idBookP);
        Client client = clientService.getByID(idClient);
        rating.setBookP(bp);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @PostMapping("/Client/{idClient}/addRating/bookN/{idBookN}")
    public Object addRatingBookNumerique(@RequestBody Rating rating,@PathVariable("idClient") Long idClient, @PathVariable("idBookN") Long idBookN)
    {
        BookNumerique bn = bookNumeriqueService.getById(idBookN);
        Client client = clientService.getByID(idClient);
        rating.setBookN(bn);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @PostMapping("/Client/{idClient}/addRating/CD/{idCD}")
    public Object addRatingCD(@RequestBody Rating rating, @PathVariable("idClient") Long idClient,@PathVariable("idCD")Long idCD)
    {
        CD cd = cdService.findById(idCD);
        Client client = clientService.getByID(idClient);
        rating.setCd(cd);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @PostMapping("/Client/{idClient}/addRating/Magazine/{idMagazine}")
    public Object addRatingMagazine(@RequestBody Rating rating, @PathVariable("idClient") Long idClient,@PathVariable("idMagazine")Long idMagazine)
    {
        Magazine magazine = magazineService.getById(idMagazine);
        Client client = clientService.getByID(idClient);
        rating.setMagazine(magazine);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }






}
