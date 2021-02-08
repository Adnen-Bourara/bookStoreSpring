package com.esprit.project.controller;

import com.esprit.project.entities.CD;
import com.esprit.project.services.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CDController {
    @Autowired
    private CDService cdService;

    @GetMapping("/cd/All")
    public Object getAll()
    {
        List<CD> cdList = cdService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(cdList);
    }

    @GetMapping("/cd/{id}")
    public Object getById(@PathVariable Long id)
    {
        CD cd = cdService.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(cd);
    }
}