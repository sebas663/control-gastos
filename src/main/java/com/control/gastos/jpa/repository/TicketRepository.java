package com.control.gastos.jpa.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import com.control.gastos.entities.Ticket;
import com.control.gastos.jpa.repository.interfaces.ITicketRepository;

public class TicketRepository extends BaseRepository<Ticket, Integer> implements ITicketRepository{
    /**
     * 
     * @param domainClass
     * @param entityManager
     */
	public TicketRepository(Class<Ticket> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}
	/**
	 * 
	 * @param entityInformation
	 * @param entityManager
	 */
	public TicketRepository(JpaEntityInformation<Ticket, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}
	
	@Override
	public List<Ticket> findByBuyDate(Date buyDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
