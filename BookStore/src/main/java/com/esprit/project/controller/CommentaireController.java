package com.esprit.project.controller;

import com.esprit.project.entities.*;
import com.esprit.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @PostMapping("/Client/{idClient}/addComment/bookA/{idBookA}")
    public Object addCommentBookAudio(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient, @PathVariable("idBookA") Long idBookA)
    {
        BookAudio ba = bookAudioService.getById(idBookA);
        Client client = clientService.getById(idClient);
        comment.setBookA(ba);
        comment.setClient(client);
        comment.setCreatedAt(new Date());
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
    @PutMapping("/Client/{idClient}/updateComment")
    public  Object updateComment(@RequestBody Commentaire comment, @PathVariable("idClient") Long idClient){
            comment.setCreatedAt(new Date());
            comment =  commentaireService.updateCommentaire(comment);
            return ResponseEntity.accepted().body(comment);

    }
    @GetMapping("/Client/getBookAComment/{idBookA}")
    public List<Commentaire> getBookAComments(@PathVariable("idBookA") Long idBook){
        List<Commentaire> l= commentaireService.findBybookA_Id(idBook);
        return  l;
    }

    @GetMapping("/Client/getBookPComment/{idBookP}")
    public List<Commentaire> getBookPComments(@PathVariable("idBookP") Long idBook){
        List<Commentaire> l= commentaireService.findByBookP_Id(idBook);
        return  l;
    }
    @GetMapping("/Client/getBookAComment/{idBookN}")
    public List<Commentaire> getBookNComments(@PathVariable("idBookN") Long idBook){
        List<Commentaire> l= commentaireService.findByBookN_Id(idBook);
        return  l;
    }
    @GetMapping("/Client/getCdComment/{idBookCD}")
    public List<Commentaire> getCDs(@PathVariable("idCD") Long idCd){
        List<Commentaire> l= commentaireService.findByCd_Id(idCd);
        return  l;
    }
    @GetMapping("/Client/getMagazineComment/{idBookM}")
    public List<Commentaire> getMagazineComments(@PathVariable("idM") Long idM){
        List<Commentaire> l= commentaireService.findByMagazine_Id(idM);
        return  l;
    }


    @DeleteMapping("/Client/deleteComment/{idComment}")
    public  void deleteComment(@PathVariable("idComment") Long idComment){
        commentaireService.deleteCommentaire(idComment);
        //test of client Id in front !
    }




}
