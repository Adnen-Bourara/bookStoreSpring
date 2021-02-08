package com.esprit.project.services;

import com.esprit.project.entities.Commentaire;

import java.util.List;

public interface CommentaireService {


    List<Commentaire> getByBookPId(Long id);
    Commentaire saveCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Commentaire commentaire);
    void deleteCommentaire(Long id);
}
