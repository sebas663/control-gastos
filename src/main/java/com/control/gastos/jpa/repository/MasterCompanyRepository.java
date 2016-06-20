package com.control.gastos.jpa.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import com.control.gastos.entities.MasterCompany;
import com.control.gastos.jpa.repository.interfaces.IMasterCompanyRepository;

public class MasterCompanyRepository extends BaseRepository<MasterCompany, Integer> implements IMasterCompanyRepository{
    /**
     * 
     * @param domainClass
     * @param entityManager
     */
	public MasterCompanyRepository(Class<MasterCompany> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}
	/**
	 * 
	 * @param entityInformation
	 * @param entityManager
	 */
	public MasterCompanyRepository(JpaEntityInformation<MasterCompany, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}
}
