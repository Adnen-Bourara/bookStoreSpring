package com.esprit.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.esprit.project.entities.BookPhysique;
import com.esprit.project.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long>{
	   List <Ticket> findByEvenement_ID(Long id);
}