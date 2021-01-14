package com.esprit.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.project.entities.BookPhysique;
import com.esprit.project.entities.Ticket;
import com.esprit.project.repositories.BookPhysiqueRepository;
import com.esprit.project.repositories.TicketRepository;
import com.esprit.project.services.TicketService;

public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> getAllTicket() {
		return (List<Ticket>) ticketRepository.findAll();

	}

	@Override
	public Ticket getById(Long id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	public List<Ticket> getListTicketByEvenementId(Long id) {
		return (List<Ticket>) ticketRepository.findByEvenement_ID(id);
	}

}
