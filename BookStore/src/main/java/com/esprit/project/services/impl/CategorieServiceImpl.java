package com.esprit.project.services.impl;

import com.esprit.project.entities.Categorie;
import com.esprit.project.repositories.CategorieRepository;
import com.esprit.project.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {
        @Autowired
        private CategorieRepository categorieRepository;

        @Override
        public List<Categorie> getAll() {
        return (List<Categorie>) categorieRepository.findAll();
        }

		@Override
		public Categorie getById(Long id) {
			
			return categorieRepository.findById(id).get();
		}
}
