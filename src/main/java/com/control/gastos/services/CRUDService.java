package com.control.gastos.services;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.control.gastos.services.interfaces.ICRUDService;

public abstract  class CRUDService<T, S, ID extends Serializable> implements ICRUDService<T, S, ID>{
   
	@Autowired
	private Mapper dozerBeanMapper;
//	@Autowired
//	private JpaRepository<T, ID> baseRepository;
	private Class<T> entityClass;
	private Class<S> dtoClass;
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public CRUDService() {
		super();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.dtoClass = (Class<S>) genericSuperclass.getActualTypeArguments()[1];
	}
	@Override
	public List<S> getAll() {
		List<S> list = new ArrayList<S>();
//		List<T> lst = baseRepository.findAll();
//		for(T t:lst){
//			list.add(getDozerBeanMapper().map(t, this.dtoClass));
//		}
		return list;
	}
	@Override
	public boolean isExist(ID id) {
//		Assert.notNull(id, "id must not be null");
//		return baseRepository.exists(id);
		return true;
	}
	@Override
	@Transactional
	public void saveOrUpdate(S entity) {
//		Assert.notNull(entity, "entity must not be null");
//		T t = getDozerBeanMapper().map(entity,  this.entityClass);
//		baseRepository.save(t);
	}
	@Override
	public S findById(ID id) {
		Assert.notNull(id, "id must not be null");
//		T t = baseRepository.findOne(id);
//		S s = getDozerBeanMapper().map(t, this.dtoClass);
		return null;
	}
	@Override
	@Transactional
	public void delete(S entity) {
//		Assert.notNull(entity, "entity must not be null");
//		T t = getDozerBeanMapper().map(entity, this.entityClass);
//		baseRepository.delete(t);
	}
	/**
	 * @return
	 */
	public Mapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}
}
