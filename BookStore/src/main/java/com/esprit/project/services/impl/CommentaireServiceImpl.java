package com.esprit.project.services.impl;

import com.esprit.project.entities.Commentaire;
import com.esprit.project.repositories.CommentaireRepository;
import com.esprit.project.services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;


    @Override
    public List<Commentaire> getByBookPId(Long id) {
        return commentaireRepository.findByBookP_Id(id);
    }

    @Override
    public Commentaire saveCommentaire(Commentaire commentaire) {

        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {

        return commentaireRepository.save(commentaire);
    }


    @Override
    public void deleteCommentaire(Long id) {
        try {
            commentaireRepository.deleteById(id);
        } catch (
                EmptyResultDataAccessException e) {
            System.out.println("doesn't exist");
        }
    }

}
