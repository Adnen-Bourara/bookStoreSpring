package com.esprit.project.repositories;

import com.esprit.project.entities.Magazine;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long> {

    List <Magazine> findByAuteur_Id(Long id);
    List <Magazine> findByEdition_Id(Long id);

}