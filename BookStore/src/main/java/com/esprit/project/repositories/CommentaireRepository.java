package com.esprit.project.repositories;

import com.esprit.project.entities.Commentaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {

    List<Commentaire> findByBookNumerique_id(Long id);
    List<Commentaire> findByBookAudio_id(Long id);
    List<Commentaire> findByBookPhysique_id(Long id);
    List<Commentaire> findByCD_id(Long id);
    List<Commentaire> findByMagazine__id(Long id);

}
