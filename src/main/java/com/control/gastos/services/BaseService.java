package com.control.gastos.services;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
	@Autowired
	private Mapper dozerBeanMapper;
	/**
	 * @return
	 */
	public Mapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}
}
