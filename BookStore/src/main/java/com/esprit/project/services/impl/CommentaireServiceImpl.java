package com.esprit.project.services.impl;

import com.esprit.project.entities.Commentaire;
import com.esprit.project.repositories.BookAudioRepository;
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
    @Autowired
    private  BookAudioRepository ba;

    @Override
    public Commentaire saveCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> findByBookPId(Long id) {
        return commentaireRepository.findByBookPId(id);
    }

    @Override
    public List<Commentaire> findByBookNId(Long id) {
        return commentaireRepository.findByBookNId(id);
    }

    @Override
    public List<Commentaire> findBybookAId(Long id) {
        return ba.findById(id).get().getCommentaire();
    }


    @Override
    public List<Commentaire> findByCdId(Long id) {
        return commentaireRepository.findByCdId(id);
    }

    @Override
    public List<Commentaire> findByMagazineId(Long id) {
        return commentaireRepository.findByMagazineId(id);
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
