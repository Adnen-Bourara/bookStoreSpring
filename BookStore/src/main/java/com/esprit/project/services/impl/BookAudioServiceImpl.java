package com.esprit.project.services.impl;

import com.esprit.project.entities.BookAudio;
import com.esprit.project.repositories.BookAudioRepository;
import com.esprit.project.services.BookAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAudioServiceImpl implements BookAudioService {


    @Autowired
    private BookAudioRepository bookAudioRepository;


    @Override
    public BookAudio getById(Long id) {
        return bookAudioRepository.findById(id).get();
    }

    @Override
    public List<BookAudio> getAllBookAudio() {
        return (List<BookAudio>) bookAudioRepository.findAll();
    }

    @Override
    public List<BookAudio> getListBookAudioByAuteurId(Long id) {
        return  (List<BookAudio>) bookAudioRepository.findByAuteur_Id(id);
    }

    @Override
    public List<BookAudio> getListBookAudioByCategorieId(Long id) {
       // System.out.println(bookAudioRepository.findByCategorie_Id(id).toString());
        return (List<BookAudio>) bookAudioRepository.findByCategorie_Id(id);
    }
}
