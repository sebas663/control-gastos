package com.control.gastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterBoxDiscountDTO;
import com.control.gastos.entities.MasterBoxDiscount;
import com.control.gastos.jpa.repository.interfaces.IMasterBoxDiscountRepository;
import com.control.gastos.services.interfaces.IMasterBoxDiscountService;

@Service("masterBoxDiscountService")
public class MasterBoxDiscountService extends BaseService<MasterBoxDiscount, MasterBoxDiscountDTO, Integer> implements IMasterBoxDiscountService{
	
	@Autowired
	private IMasterBoxDiscountRepository masterBoxDiscountRepository;
}
