package com.esprit.project.services;

import com.esprit.project.entities.BookAudio;

import java.util.List;

public interface BookAudioService {


    List<BookAudio> getAllBookAudio();
    BookAudio getById(Long id);
    List <BookAudio> findByTitre(String titre);
    List<BookAudio> getListBookAudioByAuteurId(Long id);
    List<BookAudio> getListBookAudioByCategorieId(Long id);

}
