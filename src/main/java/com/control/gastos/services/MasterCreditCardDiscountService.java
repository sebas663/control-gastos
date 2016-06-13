package com.control.gastos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterCreditCardDiscountDTO;
import com.control.gastos.entities.MasterCreditCardDiscount;
import com.control.gastos.jpa.repository.interfaces.IBaseRepository;
import com.control.gastos.jpa.repository.interfaces.IMasterCreditCardDiscountRepository;
import com.control.gastos.services.interfaces.IMasterCreditCardDiscountService;

@Service("masterCreditCardDiscountService")
public class MasterCreditCardDiscountService extends BaseService<MasterCreditCardDiscount, MasterCreditCardDiscountDTO, Integer> implements IMasterCreditCardDiscountService{
	/**
	 * 
	 */
	@Autowired
	private IMasterCreditCardDiscountRepository masterCreditCardDiscountRepository;
	
	/**
	 * @param typeT
	 * @param typeS
	 * @param baseRepository
	 */
	public MasterCreditCardDiscountService(Class<MasterCreditCardDiscount> typeT,
			Class<MasterCreditCardDiscountDTO> typeS,
			IBaseRepository<MasterCreditCardDiscount, Integer> baseRepository) {
		super(typeT, typeS, baseRepository);
	}

	private List<MasterCreditCardDiscount> getAllDummie(){
    	List<MasterCreditCardDiscount> lstCreditCardDiscounts = new ArrayList<MasterCreditCardDiscount>();
		MasterCreditCardDiscount CreditCardDiscount = new MasterCreditCardDiscount();
		CreditCardDiscount.setId(1);
		CreditCardDiscount.setDescription("PRIMER CREDIT CARD 1");
		lstCreditCardDiscounts.add(CreditCardDiscount);
		
		MasterCreditCardDiscount CreditCardDiscount2 = new MasterCreditCardDiscount();
		CreditCardDiscount2.setId(2);
		CreditCardDiscount2.setDescription("PRIMER CREDIT CARD 2");
		lstCreditCardDiscounts.add(CreditCardDiscount2);
		
		MasterCreditCardDiscount CreditCardDiscount3 = new MasterCreditCardDiscount();
		CreditCardDiscount3.setId(3);
		CreditCardDiscount3.setDescription("PRIMER CREDIT CARD 3");
		lstCreditCardDiscounts.add(CreditCardDiscount3);
		
		MasterCreditCardDiscount CreditCardDiscount4 = new MasterCreditCardDiscount();
		CreditCardDiscount4.setId(4);
		CreditCardDiscount4.setDescription("PRIMER CREDIT CARD 4");
		lstCreditCardDiscounts.add(CreditCardDiscount4);
		
		MasterCreditCardDiscount CreditCardDiscount5 = new MasterCreditCardDiscount();
		CreditCardDiscount5.setId(5);
		CreditCardDiscount5.setDescription("PRIMER CREDIT CARD 5");
		lstCreditCardDiscounts.add(CreditCardDiscount5);
		return lstCreditCardDiscounts;
	}
}
