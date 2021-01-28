package com.esprit.project.services;

import com.esprit.project.entities.Commentaire;



public interface CommentaireService {

    Commentaire saveCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Commentaire commentaire);
    void deleteCommentaire(Long id);
    // List<Commentaire> getByBookPId(Long id);

}
