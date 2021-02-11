package com.esprit.project.repositories;

import com.esprit.project.entities.Commentaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {

    List<Commentaire> findByBookNId(Long id);
    List<Commentaire> findBybookAId(Long id);
    List<Commentaire> findByBookPId(Long id);
    List<Commentaire> findByCdId(Long id);
    List<Commentaire> findByMagazineId(Long id);

}
