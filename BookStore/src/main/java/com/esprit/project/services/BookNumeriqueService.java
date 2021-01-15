package com.esprit.project.services;

import com.esprit.project.entities.BookNumerique;

import java.util.List;

public interface BookNumeriqueService {
    List<BookNumerique> getAllBookNumerique();
    BookNumerique getById(Long id);
    List<BookNumerique> getListBookNumeriqueByAuteurId(Long id);
    List<BookNumerique> getListBookNumeriqueByCategorieId(Long id);
}
