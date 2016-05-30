package com.control.gastos.jpa.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.control.gastos.jpa.repository.interfaces.IBaseRepository;

public class BaseRepository <T, ID extends Serializable>
extends SimpleJpaRepository<T, ID>  implements IBaseRepository<T, ID>{
	
	private EntityManager entityManager;

	// There are two constructors to choose from, either can be used.
	public BaseRepository(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);

		// This is the recommended method for accessing inherited class
		// dependencies.
		this.entityManager = entityManager;
	}

//	public void sharedCustomMethod(ID id) {
//		// implementation goes here
//	}

} 

