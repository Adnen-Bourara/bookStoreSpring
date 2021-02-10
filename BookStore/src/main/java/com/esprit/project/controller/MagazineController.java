package com.esprit.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.project.entities.Magazine;
import com.esprit.project.services.MagazineService;


public class MagazineController {

    @Autowired
    private MagazineService magazineService;


    @GetMapping("/Magazine/All")
    public Object getAll()
    {
        List<Magazine> magazineList = magazineService.getAllMagazine();
        return ResponseEntity.status(HttpStatus.FOUND).body(magazineList);
    }

    @GetMapping("/Magazine/{id}")
    public Object getById(@PathVariable Long id)
    {
    	Magazine magazine = magazineService.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(magazine);
    }

    @GetMapping("/Magazine/Edition/{id}")
    public Object getByEditionId(@PathVariable Long id)
    {
        List<Magazine> magazineList = magazineService.getListMagazineByEditionId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(magazineList);
    }

    @GetMapping("/Magazine/Categorie/{id}")
    public Object getByCategorieId(@PathVariable Long id)
    {
        List<Magazine> magazineList = magazineService.getListMagazineByAuteurId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(magazineList);
    }

}
