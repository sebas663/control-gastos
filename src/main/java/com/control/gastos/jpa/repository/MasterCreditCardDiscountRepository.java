package com.control.gastos.jpa.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import com.control.gastos.entities.MasterCreditCardDiscount;
import com.control.gastos.jpa.repository.interfaces.IMasterCreditCardDiscountRepository;

public class MasterCreditCardDiscountRepository extends BaseRepository<MasterCreditCardDiscount, Integer> implements IMasterCreditCardDiscountRepository{
    /**
     * 
     * @param domainClass
     * @param entityManager
     */
	public MasterCreditCardDiscountRepository(Class<MasterCreditCardDiscount> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}
	/**
	 * 
	 * @param entityInformation
	 * @param entityManager
	 */
	public MasterCreditCardDiscountRepository(JpaEntityInformation<MasterCreditCardDiscount, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}
}
