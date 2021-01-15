package com.esprit.project.services;

import com.esprit.project.entities.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTicket();
    Ticket getById(Long id);
    List<Ticket> getListTicketByEvenementId(Long id);

}
