package com.esprit.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.project.entities.BookNumerique;
import com.esprit.project.services.BookNumeriqueService;


public class BookNumeriqueController {

    @Autowired
    private BookNumeriqueService bookNumeriqueService;


    @GetMapping("/BookNumerique/All")
    public Object getAll()
    {
        List<BookNumerique> bookNumeriqueList = bookNumeriqueService.getAllBookNumerique();
        return ResponseEntity.status(HttpStatus.FOUND).body(bookNumeriqueList);
    }

    @GetMapping("/BookNumerique/{id}")
    public Object getById(@PathVariable Long id)
    {
    	BookNumerique bookNumerique = bookNumeriqueService.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(bookNumerique);
    }

    @GetMapping("/BookNumerique/Auteur/{id}")
    public Object getByAuteurId(@PathVariable Long id)
    {
        List<BookNumerique> bookNumeriqueList = bookNumeriqueService.getListBookNumeriqueByAuteurId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(bookNumeriqueList);
    }

    @GetMapping("/BookNumerique/Categorie/{id}")
    public Object getByCategorieId(@PathVariable Long id)
    {
        List<BookNumerique> bookNumeriqueList = bookNumeriqueService.getListBookNumeriqueByCategorieId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(bookNumeriqueList);
    }
}
