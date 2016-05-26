package com.control.gastos.interfaces.services;

import com.control.gastos.dtos.TicketDTO;

public interface ITicketService {
	void save(TicketDTO ticket);
	boolean isTicketExist(TicketDTO ticket);
}
