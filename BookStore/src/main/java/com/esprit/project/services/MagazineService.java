package com.esprit.project.services;

import com.esprit.project.entities.Magazine;

import java.util.List;

public interface MagazineService {
    List<Magazine> getAllMagazine();
    Magazine getById(Long id);
    List<Magazine> getListMagazineByAuteurId(Long id);
    List<Magazine> getListMagazineByEditionId(Long id);
}
