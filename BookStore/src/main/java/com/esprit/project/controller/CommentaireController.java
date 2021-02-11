package com.esprit.project.controller;

import com.esprit.project.entities.*;
import com.esprit.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@RestController
public class CommentaireController {

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

    @Autowired
    private CommentaireService commentaireService;
    public static Boolean banned = false;

    @PostMapping("/Client/{idClient}/addComment/bookA/{idBookA}")
    public Object addCommentBookAudio(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient, @PathVariable("idBookA") Long idBookA) throws FileNotFoundException {
        BookAudio ba = null;
        Client client = null;
        try{
           ba = bookAudioService.getById(idBookA);
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            
             client = clientService.getById(idClient);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       

        comment.setBookA(ba);
        comment.setClient(client);
        comment.setCreatedAt(new Date());
        comment.setTexte(FilterBadWords(comment.getTexte()));
        if (banned == true){
            client.setIsBanned(true);
            clientService.save(client);
        }
        comment =  commentaireService.saveCommentaire(comment);
        return ResponseEntity.status(HttpStatus.FOUND).body(comment);
    }
    @PostMapping("/Client/{idClient}/addComment/bookP/{idBookA}")
    public Object addCommentBookPhysique(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient, @PathVariable("idBookP") Long idBooP)
    {
        BookPhysique bp = bookPhysiqueService.getById(idBooP);
        Client client = clientService.getById(idClient);
        comment.setBookP(bp);
        comment.setClient(client);
        comment.setCreatedAt(new Date());
        comment =  commentaireService.saveCommentaire(comment);
        return ResponseEntity.status(HttpStatus.FOUND).body(comment);
    }
    @PostMapping("/Client/{idClient}/addComment/bookP/{idBookN}")
    public Object addCommentBookNumerique(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient, @PathVariable("idBookN") Long idBooN)
    {
        BookNumerique bn = bookNumeriqueService.getById(idBooN);
        Client client = clientService.getById(idClient);
        comment.setBookN(bn);
        comment.setClient(client);
        comment.setCreatedAt(new Date());
        comment =  commentaireService.saveCommentaire(comment);
        return ResponseEntity.status(HttpStatus.FOUND).body(comment);
    }
    @PostMapping("/Client/{idClient}/addComment/magazine/{idMagazine}")
    public Object addCommentMagazine(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient, @PathVariable("idMagazine") Long idMagazine)
    {
        Magazine magazine = magazineService.getById(idMagazine);
        Client client = clientService.getById(idClient);
        comment.setMagazine(magazine);
        comment.setClient(client);
        comment.setCreatedAt(new Date());
        comment =  commentaireService.saveCommentaire(comment);
        return ResponseEntity.status(HttpStatus.FOUND).body(comment);
    }
    @PostMapping("/Client/{idClient}/addComment/cd/{idCd}")
    public Object addCommentCd(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient, @PathVariable("idCd") Long idC)
    {
        CD cd = cdService.findById(idC);
        Client client = clientService.getById(idClient);
        comment.setCd(cd);
        comment.setClient(client);
        comment.setCreatedAt(new Date());
        comment =  commentaireService.saveCommentaire(comment);
        return ResponseEntity.status(HttpStatus.FOUND).body(comment);
    }
    @PutMapping("/Comment/update")
    public  Object updateComment(@RequestBody Commentaire comment) throws FileNotFoundException {
            //comment.setId(idCom);
        Client client = clientService.getById(comment.getClient().getId());
        if(client.getIsBanned()){
            return ResponseEntity.status(HttpStatus.FOUND).body("you are banned!");
        }else {
            comment.setTexte(FilterBadWords(comment.getTexte()));
            if (banned == true){
                client.setIsBanned(true);
                clientService.save(client);
            }
            comment.setCreatedAt(new Date());
            return  commentaireService.updateCommentaire(comment);
        }


    }
    @GetMapping("/Client/getBookAComment/{idBookA}")
    public Object getBookAComments(@PathVariable("idBookA") Long idBook){
        List<Commentaire> l = commentaireService.findBybookAId(idBook);
        return  ResponseEntity.status(HttpStatus.FOUND).body(l);
    }

    @GetMapping("/Client/getBookPComment/{idBookP}")
    public List<Commentaire> getBookPComments(@PathVariable("idBookP") Long idBook){
        return commentaireService.findByBookPId(idBook);
    }
    @GetMapping("/Client/getBookNComment/{idBookN}")
    public List<Commentaire> getBookNComments(@PathVariable("idBookN") Long idBook){
        return commentaireService.findByBookNId(idBook);

    }
    @GetMapping("/Client/getCdComment/{idBookCD}")
    public List<Commentaire> getCDs(@PathVariable("idCD") Long idCd){
        return commentaireService.findByCdId(idCd);
    }
    @GetMapping("/Client/getMagazineComment/{idBookM}")
    public List<Commentaire> getMagazineComments(@PathVariable("idM") Long idM){
        return commentaireService.findByMagazineId(idM);
    }


    @DeleteMapping("/Client/deleteComment/{idComment}")
    public  void deleteComment(@PathVariable("idComment") Long idComment){
        commentaireService.deleteCommentaire(idComment);
        //test of client Id in front !
    }

    public static ArrayList<String> remp() throws FileNotFoundException {

        Scanner s = new Scanner(new File("D:\\badWord.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }
    public static String FilterBadWords(String input) throws FileNotFoundException {
        StringBuilder s = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            for (String word : remp()) {
                try {
                    if (input.substring(i, word.length()+i).equalsIgnoreCase(word)) {
                       banned =  true;
                        for (int j = i; j < i + word.length(); j++) {
                            s.setCharAt(j, '*');
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return s.toString();
    }



}
