package com.control.gastos.jpa.repository.interfaces;

import java.util.Date;
import java.util.List;

import com.control.gastos.entities.Ticket;

public interface ITicketRepository extends IBaseRepository<Ticket, Integer>{
	List<Ticket> findByBuyDate(Date buyDate);
}
