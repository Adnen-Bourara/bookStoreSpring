package com.esprit.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entities.BookPhysique;
import com.esprit.project.repositories.BookPhysiqueRepository;
import com.esprit.project.services.BookPhysiqueService;
@Service
public class BookPhysiqueServiceImpl implements BookPhysiqueService{

	
	@Autowired
	BookPhysiqueRepository bookPhysiqueRepository;
	


	@Override
	public List<BookPhysique> getAllBookPhysique() {
		return (List<BookPhysique>) bookPhysiqueRepository.findAll();
	}

	@Override
	public BookPhysique getById(Long id) {

		return bookPhysiqueRepository.findById(id).get();
	}

	@Override
	public List<BookPhysique> getListBookPhysiqueByAuteurId(Long id) {
		return (List<BookPhysique>) bookPhysiqueRepository.findByAuteur_Id(id);
	}

	@Override
	public List<BookPhysique> getListBookPhysiqueByCategorieId(Long id) {
		return (List<BookPhysique>) bookPhysiqueRepository.findByCategorie_Id(id);
	}

}
