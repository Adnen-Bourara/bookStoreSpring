package com.esprit.project.controller;

import com.esprit.project.entities.BookAudio;
import com.esprit.project.services.BookAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookAudioController {

    @Autowired
    private BookAudioService bookAudioService;

    @GetMapping("/BookAudio/All")
    public  Object getAll(){
        List<BookAudio> baList = bookAudioService.getAllBookAudio();
        return ResponseEntity.status(HttpStatus.FOUND).body(baList);
    }
    @GetMapping("/BookAudio/{id}")
    public  Object getById(@PathVariable Long id){
        BookAudio ba = bookAudioService.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(ba);
    }

    @GetMapping("/BookAudio/Auteur/{id}")
    public Object getByAuteurId(@PathVariable Long id)
    {
        List<BookAudio> bookAudioList = bookAudioService.getListBookAudioByAuteurId(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(bookAudioList);
    }

    @GetMapping("/BookAudio/Categorie/{id}")
    public Object getByCategorieId(@PathVariable Long id){
        List<BookAudio> baList = bookAudioService.getListBookAudioByCategorieId(id);
        return  ResponseEntity.status(HttpStatus.FOUND).body(baList);
    }


}
