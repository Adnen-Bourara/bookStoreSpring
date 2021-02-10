package com.esprit.project.services;

import java.util.List;

import com.esprit.project.entities.Magazine;

public interface MagazineService {
	List<Magazine> getAllMagazine();
	Magazine getById(Long id);
	List<Magazine> getListMagazineByAuteurId(Long id);
	List<Magazine> getListMagazineByEditionId(Long id);
}
