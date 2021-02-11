package com.esprit.project.repositories;

import com.esprit.project.entities.Commentaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {

    List<Commentaire> findByBookN_Id(Long id);
    List<Commentaire> findBybookA_Id(Long id);
    List<Commentaire> findByBookP_Id(Long id);
    List<Commentaire> findByCd_Id(Long id);
    List<Commentaire> findByMagazine_Id(Long id);

}
