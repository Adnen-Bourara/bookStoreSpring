package com.esprit.project.services;

import com.esprit.project.entities.Commentaire;

import java.util.List;


public interface CommentaireService {


    List<Commentaire> findByBookPId(Long id);
    List<Commentaire> findByBookNId(Long id);
    List<Commentaire> findBybookAId(Long id);
    List<Commentaire> findByCdId(Long id);
    List<Commentaire> findByMagazineId(Long id);
    Commentaire saveCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Commentaire commentaire);
    void deleteCommentaire(Long id);
}
