package com.esprit.project.services;

import java.util.List;

import com.esprit.project.entities.BookPhysique;

public interface BookPhysiqueService {
	
	List<BookPhysique> getAllBookPhysiques();
	BookPhysique getById(Long id);

}
