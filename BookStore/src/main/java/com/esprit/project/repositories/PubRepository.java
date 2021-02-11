package com.esprit.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entities.Pub;

@Repository
public interface PubRepository extends CrudRepository<Pub,Long>{
	Pub findByClient_Id(Long IdClient);
}
