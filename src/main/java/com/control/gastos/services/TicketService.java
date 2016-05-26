package com.control.gastos.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.TicketDTO;
import com.control.gastos.entities.Ticket;
import com.control.gastos.interfaces.services.ITicketService;
import com.control.gastos.jpa.repository.TicketRepository;

@Service("ticketService")
public class TicketService extends BaseService implements ITicketService{
	
	@Autowired 
	private TicketRepository ticketRepository;
	
	@Override
	public void save(TicketDTO obj) {
		Ticket ticket = new Ticket();
		ticket = getDozerBeanMapper().map(obj, Ticket.class);
		ticketRepository.save(ticket);
	}

	@Override
	public boolean isTicketExist(TicketDTO ticket) {
		boolean exist = false;
		if(ticket.getId() != null){
			exist = ticketRepository.exists(ticket.getId());
		}
		return exist;
	}
	
}
