package com.control.gastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.interfaces.services.IMasterProductService;
import com.control.gastos.jpa.repository.interfaces.MasterProductRepository;

@Service("masterProductService")
public class MasterProductService extends BaseService implements IMasterProductService{
	@Autowired 
	private MasterProductRepository masterProductRepository;
}
