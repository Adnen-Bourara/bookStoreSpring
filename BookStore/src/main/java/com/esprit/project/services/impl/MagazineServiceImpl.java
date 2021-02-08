package com.esprit.project.services.impl;

import com.esprit.project.entities.Magazine;
import com.esprit.project.repositories.MagazineRepository;
import com.esprit.project.services.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MagazineServiceImpl implements MagazineService {


    @Autowired
    MagazineRepository magazineRepository;


    @Override
    public List<Magazine> getAllMagazine() {
        return (List<Magazine>) magazineRepository.findAll();
    }

    @Override
    public Magazine getById(Long id) {
        return magazineRepository.findById(id).get();
    }

    @Override
    public List<Magazine> getListMagazineByAuteurId(Long id) {
        return (List<Magazine>) magazineRepository.findByAuteur_Id(id);
    }

    @Override
    public List<Magazine> getListMagazineByEdition(Integer edition) {
        return (List<Magazine>) magazineRepository.findByEdition(edition);
    }

}
