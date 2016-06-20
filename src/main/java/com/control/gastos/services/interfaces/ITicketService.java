package com.control.gastos.services.interfaces;

import java.util.Date;
import java.util.List;

import com.control.gastos.dtos.TicketDTO;
import com.control.gastos.entities.Ticket;

public interface ITicketService extends ICRUDService<Ticket, TicketDTO, Integer>{
	List<TicketDTO> findByBuyDate(Date buyDate);
}
