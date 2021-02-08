package com.esprit.project.controller;

import com.esprit.project.entities.*;
import com.esprit.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        Client client = clientService.getById(idClient);
        rating.setBookA(ba);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }




    @PostMapping("/Client/{idClient}/addRating/bookP/{idBookP}")
    public Object addRatingBookPhysique(@RequestBody Rating rating, @PathVariable("idClient") Long idClient, @PathVariable("idBookP") Long idBookP)
    {
        BookPhysique bp = bookPhysiqueService.getById(idBookP);
        Client client = clientService.getById(idClient);
        rating.setBookP(bp);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @PostMapping("/Client/{idClient}/addRating/bookN/{idBookN}")
    public Object addRatingBookNumerique(@RequestBody Rating rating,@PathVariable("idClient") Long idClient, @PathVariable("idBookN") Long idBookN)
    {
        BookNumerique bn = bookNumeriqueService.getById(idBookN);
        Client client = clientService.getById(idClient);
        rating.setBookN(bn);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @PostMapping("/Client/{idClient}/addRating/CD/{idCD}")
    public Object addRatingCD(@RequestBody Rating rating, @PathVariable("idClient") Long idClient,@PathVariable("idCD")Long idCD)
    {
        CD cd = cdService.findById(idCD);
        Client client = clientService.getById(idClient);
        rating.setCd(cd);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @PostMapping("/Client/{idClient}/addRating/Magazine/{idMagazine}")
    public Object addRatingMagazine(@RequestBody Rating rating, @PathVariable("idClient") Long idClient,@PathVariable("idMagazine")Long idMagazine)
    {
        Magazine magazine = magazineService.getById(idMagazine);
        Client client = clientService.getById(idClient);
        rating.setMagazine(magazine);
        rating.setClient(client);
        rating =  ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }



    @GetMapping("/Client/{idClent}/whatDoILike/{minimum}")
    public Object whatDoILike(@PathVariable("idClent") Long id,@PathVariable("minimum") Float minimum )
    {
        //get the books that the client rated above min
        List<Rating> booksPhyILoved =  ratingService.findByClientandBookPIsNotNull(id,minimum);
        List<Long> booksIdILoved = new ArrayList<>();
        //extract red books
        for( Rating r: booksPhyILoved)
            booksIdILoved.add(r.getBookP().getId());
        List<Rating> whoAlsoLovedMyBooks = new ArrayList<>();
       for ( Rating r : booksPhyILoved )
       {
           //get the ratings given to the books that the client liked
           List<Rating> allRatingsforLovedBooks = ratingService.findByBookPId(r.getBookP().getId(),minimum);
           for (Rating r1 : allRatingsforLovedBooks )
               whoAlsoLovedMyBooks.add(r1);
       }
       //only keep new clients and sort
        whoAlsoLovedMyBooks = whoAlsoLovedMyBooks.stream().filter(elem -> elem.getClient().getId()!= id ).sorted((a,b) -> b.getNote().compareTo(a.getNote())).collect(Collectors.toList());

        List<Rating> booksIMightLike = new ArrayList<>();

        for (Rating r: whoAlsoLovedMyBooks )
        {
            //get All the books other client liked
            List<Rating> booksOtherClientsLiked = ratingService.findByClientandBookPIsNotNull(r.getClient().getId(),minimum);
            for (Rating r1 :booksOtherClientsLiked )
                booksIMightLike.add(r1);
        }
        //keep only disctinc books the client didn't read
        TreeSet<Rating> distinctBooks = booksIMightLike.stream().filter(a -> !(booksIdILoved.contains(a.getBookP().getId()))).collect(Collectors.toCollection(()->
            new TreeSet<Rating>(Comparator.comparing(a -> a.getBookP().getId()))));
        return ResponseEntity.status(HttpStatus.FOUND).body(distinctBooks);
    }







}
