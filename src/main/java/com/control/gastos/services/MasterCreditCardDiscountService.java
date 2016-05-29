package com.control.gastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.interfaces.services.IMasterCreditCardDiscountService;
import com.control.gastos.jpa.repository.interfaces.MasterCreditCardDiscountRepository;

@Service("masterCreditCardDiscountService")
public class MasterCreditCardDiscountService extends BaseService implements IMasterCreditCardDiscountService{
	
	@Autowired
	private MasterCreditCardDiscountRepository masterCreditCardDiscountRepository;
}
