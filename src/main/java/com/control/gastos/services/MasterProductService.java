package com.control.gastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterProductDTO;
import com.control.gastos.entities.MasterProduct;
import com.control.gastos.jpa.repository.interfaces.IMasterProductRepository;
import com.control.gastos.services.interfaces.IMasterProductService;

@Service("masterProductService")
public class MasterProductService extends BaseService<MasterProduct, MasterProductDTO, Integer> implements IMasterProductService{
	@Autowired 
	private IMasterProductRepository masterProductRepository;
}
