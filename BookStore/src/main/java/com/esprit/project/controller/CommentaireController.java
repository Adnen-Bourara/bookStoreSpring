package com.esprit.project.controller;

import com.esprit.project.entities.*;
import com.esprit.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/Client/{idClient}/addComment/bookA/{idBookA}")
    public Object addCommentBookAudio(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient, @PathVariable("idBookA") Long idBookA)
    {
        BookAudio ba = bookAudioService.getById(idBookA);
        Client client = clientService.getById(idClient);
        comment.setBookA(ba);
        comment.setClient(client);
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
        comment =  commentaireService.saveCommentaire(comment);
        return ResponseEntity.status(HttpStatus.FOUND).body(comment);
    }
    @DeleteMapping("/Client/deleteComment/{idComment}")
    public  void deleteComment(@PathVariable("idComment") Long idComment){
        commentaireService.deleteCommentaire(idComment);
        //test of client Id in front !
    }



}
