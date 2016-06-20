package com.control.gastos.jpa.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.control.gastos.jpa.repository.interfaces.IBaseRepository;

public class CustomRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
		extends JpaRepositoryFactoryBean<R, T, I> {

	@SuppressWarnings("rawtypes")
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {

		return new CustomRepositoryFactory(entityManager);
	}
	/**
	 * Private static class
	 * @author sebastian
	 *
	 * @param <T>
	 * @param <I>
	 */
	private static class CustomRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory{
		
		private final EntityManager entityManager;

		public CustomRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
	        this.entityManager = entityManager;
		}
		
		@SuppressWarnings({ "unused", "unchecked" })
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			return new BaseRepository<T, I>((Class<T>)metadata.getDomainType(), entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return BaseRepository.class;
		}
	}
}