package com.control.gastos.jpa.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.control.gastos.jpa.repository.interfaces.IBaseRepository;
@NoRepositoryBean
public class BaseRepository <T, ID extends Serializable>
extends SimpleJpaRepository<T, ID>  implements IBaseRepository<T, ID>{
	
	private  EntityManager entityManager;
	private  JpaEntityInformation<T, ?> entityInformation;
	

	/**
	 * Creates a new {@link SimpleJpaRepository} to manage objects of the given
	 * domain type.
	 *
	 * @param domainClass
	 * @param em
	 */
	public BaseRepository(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);

		// This is the recommended method for accessing inherited class
		// dependencies.
		this.entityManager = entityManager;
	}

	/**
	 * @param entityInformation
	 * @param entityManager
	 */
	public BaseRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}
	
} 

