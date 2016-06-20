package com.control.gastos.jpa.repository.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.gastos.entities.Ticket;
@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer>,IBaseRepository<Ticket, Integer>{
	List<Ticket> findByBuyDate(Date buyDate);
}
