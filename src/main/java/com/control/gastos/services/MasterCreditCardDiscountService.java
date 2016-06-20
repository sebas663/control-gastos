package com.control.gastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterCreditCardDiscountDTO;
import com.control.gastos.entities.MasterCreditCardDiscount;
import com.control.gastos.jpa.repository.interfaces.IMasterCreditCardDiscountRepository;
import com.control.gastos.services.interfaces.IMasterCreditCardDiscountService;

@Service("masterCreditCardDiscountService")
public class MasterCreditCardDiscountService extends CRUDService<MasterCreditCardDiscount, MasterCreditCardDiscountDTO, Integer> implements IMasterCreditCardDiscountService{
	/**
	 * 
	 */
	@Autowired
	private static IMasterCreditCardDiscountRepository masterCreditCardDiscountRepository;
}
