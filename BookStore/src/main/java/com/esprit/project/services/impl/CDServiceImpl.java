package com.esprit.project.services.impl;

import com.esprit.project.entities.CD;
import com.esprit.project.repositories.CDRepository;
import com.esprit.project.services.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CDServiceImpl implements CDService {

final CDRepository cdrep;
    @Autowired
    public CDServiceImpl(CDRepository cdrep){
        this.cdrep=cdrep;
    }
    @Override
    public List<CD> findAll() {
        return cdrep.findAll();
    }

    @Override
    public CD findById(Long id) {
        return  cdrep.findById(id).orElse(null);
    }

    @Override
    public Object findByTitre(String titre) {
        return cdrep.findByTitre(titre);
    }


  /*  @Override
    public CD findByTitre(String titre) {
         return  cdrep.findByTitre(titre).orElse(null);
    }*/
}
