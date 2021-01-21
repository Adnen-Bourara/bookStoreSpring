package com.esprit.project.repositories;

import com.esprit.project.entities.BookAudio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookAudioRepository extends CrudRepository<BookAudio,Long>
{

    List<BookAudio> findByAuteur_Id(Long id);
    List <BookAudio> findByCategorie_Id(Long id);

}
