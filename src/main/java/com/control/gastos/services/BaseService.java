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
	private final Class<T> typeT;
	private final Class<S> typeS;
	/**
	 * @param typeT
	 * @param typeS
	 */
	public BaseService(Class<T> typeT, Class<S> typeS) {
		super();
		this.typeT = typeT;
		this.typeS = typeS;
	}
	@Override
	public List<S> getAll() {
		List<S> list = new ArrayList<S>();
		List<T> lst = baseRepository.findAll();
		for(T t:lst){
			list.add(getDozerBeanMapper().map(t, this.getTypeS()));
		}
		return list;
	}
	@Override
	public boolean isExist(ID id) {
		return baseRepository.exists(id);
	}
	@Override
	@Transactional
	public void saveOrUpdate(S entity) {
		T t = getDozerBeanMapper().map(entity, this.getTypeT());
		baseRepository.save(t);
	}
	@Override
	public S findById(ID id) {
		T t = baseRepository.findOne(id);
		S s = getDozerBeanMapper().map(t, this.getTypeS());
		return s;
	}
	@Override
	@Transactional
	public void delete(S entity) {
		T t = getDozerBeanMapper().map(entity, this.getTypeT());
		baseRepository.delete(t);
	}
	/**
	 * @return
	 */
	public Mapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}
	/**
	 * 
	 * @return
	 */
	public Class<T> getTypeT() {
        return this.typeT;
    }
	/**
	 * 
	 * @return
	 */
	public Class<S> getTypeS() {
        return this.typeS;
    }
	
}
