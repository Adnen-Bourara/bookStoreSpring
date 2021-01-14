package com.esprit.project.services;

import java.util.List;
import com.esprit.project.entities.Ticket;

public interface TicketService {
	List<Ticket> getAllTicket();
	Ticket getById(Long id);
	List<Ticket> getListTicketByEvenementId(Long id);
	////////// trest git add .
}
