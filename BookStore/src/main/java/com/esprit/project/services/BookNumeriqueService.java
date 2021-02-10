package com.esprit.project.services;

import java.util.List;

import com.esprit.project.entities.BookNumerique;

public interface BookNumeriqueService {
	List<BookNumerique> getAllBookNumerique();
	BookNumerique getById(Long id);
	List<BookNumerique> getListBookNumeriqueByAuteurId(Long id);
	List<BookNumerique> getListBookNumeriqueByCategorieId(Long id);
}
