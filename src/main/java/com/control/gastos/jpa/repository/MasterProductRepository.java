package com.control.gastos.jpa.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import com.control.gastos.entities.MasterProduct;
import com.control.gastos.jpa.repository.interfaces.IMasterProductRepository;

public class MasterProductRepository extends BaseRepository<MasterProduct, Integer> implements IMasterProductRepository{
    /**
     * 
     * @param domainClass
     * @param entityManager
     */
	public MasterProductRepository(Class<MasterProduct> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}
	/**
	 * 
	 * @param entityInformation
	 * @param entityManager
	 */
	public MasterProductRepository(JpaEntityInformation<MasterProduct, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}
}
