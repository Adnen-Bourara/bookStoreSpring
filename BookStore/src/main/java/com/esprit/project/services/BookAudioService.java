package com.esprit.project.services;

import com.esprit.project.entities.BookAudio;

import java.util.List;

public interface BookAudioService {

    BookAudio getById(Long id);
    List<BookAudio> getAllBookAudio();
    List<BookAudio> getListBookAudioByAuteurId(Long id);
    List<BookAudio> getListBookAudioByCategorieId(Long id);

}
