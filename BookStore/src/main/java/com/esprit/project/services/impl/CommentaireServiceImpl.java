package com.esprit.project.services.impl;

import com.esprit.project.entities.Commentaire;
import com.esprit.project.repositories.CommentaireRepository;
import com.esprit.project.services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;


    @Override
    public List<Commentaire> getByBookPId(Long id) {
        return (List<Commentaire>) commentaireRepository.findByBookP_Id(id);
    }
}
