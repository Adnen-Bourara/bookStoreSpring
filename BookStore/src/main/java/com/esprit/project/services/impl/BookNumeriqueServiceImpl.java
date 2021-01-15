package com.esprit.project.services.impl;

import com.esprit.project.entities.BookNumerique;
import com.esprit.project.repositories.BookNumeriqueRepository;
import com.esprit.project.services.BookNumeriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookNumeriqueServiceImpl implements BookNumeriqueService {

    @Autowired
    BookNumeriqueRepository bookNumeriqueRepository;

    @Override
    public List<BookNumerique> getAllBookNumerique() {
        return (List<BookNumerique>) bookNumeriqueRepository.findAll();
    }

    @Override
    public BookNumerique getById(Long id) {
        return bookNumeriqueRepository.findById(id).get();
    }

    @Override
    public List<BookNumerique> getListBookNumeriqueByAuteurId(Long id) {
        return (List<BookNumerique>) bookNumeriqueRepository.findByAuteur_Id(id);
    }

    @Override
    public List<BookNumerique> getListBookNumeriqueByCategorieId(Long id) {
        return (List<BookNumerique>) bookNumeriqueRepository.findByCategorie_Id(id);
    }

}
