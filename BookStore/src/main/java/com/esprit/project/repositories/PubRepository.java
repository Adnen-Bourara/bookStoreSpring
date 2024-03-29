package com.esprit.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entities.Pub;

@Repository
public interface PubRepository extends CrudRepository<Pub,Long>{
	List<Pub> findByCategorie_Id(Long id);
}
