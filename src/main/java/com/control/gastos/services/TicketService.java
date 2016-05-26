package com.control.gastos.services;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.TicketDTO;
import com.control.gastos.entities.Ticket;
import com.control.gastos.interfaces.services.ITicketService;
import com.control.gastos.jpa.repository.TicketRepository;

@Service("ticketService")
public class TicketService implements ITicketService{
	@Autowired 
	private TicketRepository ticketRepository;
	
	@Autowired
	private Mapper dozerBeanMapper;

	@Override
	public void save(TicketDTO obj) {
		Ticket ticket = new Ticket();
//		ticket = getDozerBeanMapper().map(obj, Ticket.class);
		ticketRepository.save(ticket);
	}

	@Override
	public boolean isTicketExist(Ticket ticket) {
		boolean exist = false;
		if(ticket.getId() != null){
			exist = ticketRepository.exists(ticket.getId().intValue());
		}
		return exist;
	}
	/**
	 * @return
	 */
	public Mapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}
}
