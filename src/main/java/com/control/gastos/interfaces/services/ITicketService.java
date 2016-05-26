package com.control.gastos.interfaces.services;

import com.control.gastos.dtos.TicketDTO;
import com.control.gastos.entities.Ticket;

public interface ITicketService {
	void save(TicketDTO ticket);
	boolean isTicketExist(Ticket ticket);
}
