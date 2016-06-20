package com.control.gastos.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.control.gastos.dtos.TicketDTO;
import com.control.gastos.entities.Ticket;
import com.control.gastos.jpa.repository.interfaces.ITicketRepository;
import com.control.gastos.services.interfaces.ITicketService;

@Service("ticketService")
public class TicketService extends CRUDService<Ticket, TicketDTO, Integer> implements ITicketService{
	
	@Autowired
	private static ITicketRepository ticketRepository;
	/**
	 * 
	 */
	@Override
	public List<TicketDTO> findByBuyDate(Date buyDate) {
		Assert.notNull(buyDate, "buyDate must not be null");
		List<TicketDTO> l = new ArrayList<TicketDTO>();
		List<Ticket> lst = ticketRepository.findByBuyDate(buyDate);
		for(Ticket t:lst){
			l.add(this.getDozerBeanMapper().map(t,TicketDTO.class));
		}
		return l;
	}
}
