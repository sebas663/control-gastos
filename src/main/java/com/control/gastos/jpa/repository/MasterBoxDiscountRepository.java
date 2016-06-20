package com.control.gastos.jpa.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import com.control.gastos.entities.MasterBoxDiscount;
import com.control.gastos.jpa.repository.interfaces.IMasterBoxDiscountRepository;

public class MasterBoxDiscountRepository extends BaseRepository<MasterBoxDiscount, Integer> implements IMasterBoxDiscountRepository	{
    /**
     * 
     * @param domainClass
     * @param entityManager
     */
	public MasterBoxDiscountRepository(Class<MasterBoxDiscount> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}
	/**
	 * 
	 * @param entityInformation
	 * @param entityManager
	 */
	public MasterBoxDiscountRepository(JpaEntityInformation<MasterBoxDiscount, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}
}
