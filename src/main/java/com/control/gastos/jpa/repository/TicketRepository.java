package com.control.gastos.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.control.gastos.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
}