package com.esprit.project.services;

import java.util.List;

import com.esprit.project.entities.BookPhysique;

public interface BookPhysiqueService {
	
	List<BookPhysique> getAllBookPhysique();
	BookPhysique getById(Long id);
	List<BookPhysique> getListBookPhysiqueByAuteurId(Long id);
	List<BookPhysique> getListBookPhysiqueByCategorieId(Long id);



}
