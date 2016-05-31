package com.control.gastos.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.control.gastos.jpa.repository.interfaces.IBaseRepository;
import com.control.gastos.services.interfaces.IBaseService;

public class BaseService<T, S, ID extends Serializable> implements IBaseService<T, S, ID>{
	@Autowired
    private IBaseRepository<T, ID> baseRepository;
	@Autowired
	private Mapper dozerBeanMapper;
	/**
	 * @return
	 */
	public Mapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}
	@Override
	public List<S> getAll(final Class<S> destType) {
		List<S> list = new ArrayList<S>();
		List<T> lst = baseRepository.findAll();
		for(T t:lst){
			list.add(getDozerBeanMapper().map(t, destType));
		}
		return list;
	}
	@Override
	public boolean isExist(ID id) {
		return baseRepository.exists(id);
	}
	@Override
	@Transactional
	public void saveOrUpdate(S entity, final Class<T> destType) {
		T t = getDozerBeanMapper().map(entity, destType);
		baseRepository.save(t);
	}
	@Override
	public S findById(ID id, final Class<S> destType) {
		T t = baseRepository.findOne(id);
		S s = getDozerBeanMapper().map(t, destType);
		return s;
	}
	@Override
	@Transactional
	public void delete(S entity, final Class<T> destType) {
		T t = getDozerBeanMapper().map(entity, destType);
		baseRepository.delete(t);
	}
	
}
