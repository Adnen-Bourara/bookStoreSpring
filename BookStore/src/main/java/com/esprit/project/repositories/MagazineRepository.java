package com.esprit.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.esprit.project.entities.Magazine;

public interface MagazineRepository extends CrudRepository<Magazine, Long> {

    List <Magazine> findByAuteur_Id(Long id);
    List <Magazine> findByEdition_Id(Long id);

}
