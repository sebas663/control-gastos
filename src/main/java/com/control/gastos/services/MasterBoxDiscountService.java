package com.control.gastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.interfaces.services.IMasterBoxDiscountService;
import com.control.gastos.jpa.repository.interfaces.MasterBoxDiscountRepository;

@Service("masterBoxDiscountService")
public class MasterBoxDiscountService extends BaseService implements IMasterBoxDiscountService{
	
	@Autowired
	private MasterBoxDiscountRepository masterBoxDiscountRepository;
}
