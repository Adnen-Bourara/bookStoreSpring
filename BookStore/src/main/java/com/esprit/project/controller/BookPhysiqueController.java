package com.esprit.project.controller;

import com.esprit.project.entities.BookPhysique;
import com.esprit.project.services.BookPhysiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookPhysiqueController {

    @Autowired
    private BookPhysiqueService bookPhysiqueService;


    @GetMapping("/BookPhysique/All")
    public Object getAll()
    {
        List<BookPhysique> bookPhysiqueList = bookPhysiqueService.getAllBookPhysique();
        return ResponseEntity.status(HttpStatus.FOUND).body(bookPhysiqueList);
    }

    @GetMapping("/BookPhysique/{id}")
    public Object getById(@PathVariable Long id)
    {
        BookPhysique bookPhysique = bookPhysiqueService.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(bookPhysique);
    }

    @GetMapping("/BookPhysique/Auteur/{id}")
    public Object getByAuteurId(@PathVariable Long id)
    {
        List<BookPhysique> bookPhysiqueList = bookPhysiqueService.getListBookPhysiqueByAuteurId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(bookPhysiqueList);
    }

    @GetMapping("/BookPhysique/Categorie/{id}")
    public Object getByCategorieId(@PathVariable Long id)
    {
        List<BookPhysique> bookPhysiqueList = bookPhysiqueService.getListBookPhysiqueByCategorieId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(bookPhysiqueList);
    }

    @GetMapping("/Helloworld")
    public Object sallem()
    {
        return ResponseEntity.status(HttpStatus.CREATED).body("Hello");
    }


}
