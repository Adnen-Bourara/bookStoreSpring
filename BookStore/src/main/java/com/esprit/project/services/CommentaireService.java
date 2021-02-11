package com.esprit.project.services;

import com.esprit.project.entities.Commentaire;

import java.util.List;

public interface CommentaireService {


    List<Commentaire> findByBookP_Id(Long id);
    List<Commentaire> findByBookN_Id(Long id);
    List<Commentaire> findBybookA_Id(Long id);
    List<Commentaire> findByCd_Id(Long id);
    List<Commentaire> findByMagazine_Id(Long id);
    Commentaire saveCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Commentaire commentaire);
    void deleteCommentaire(Long id);
}
