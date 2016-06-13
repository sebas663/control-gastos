package com.control.gastos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterBoxDiscountDTO;
import com.control.gastos.entities.MasterBoxDiscount;
import com.control.gastos.jpa.repository.interfaces.IBaseRepository;
import com.control.gastos.jpa.repository.interfaces.IMasterBoxDiscountRepository;
import com.control.gastos.services.interfaces.IMasterBoxDiscountService;

@Service("masterBoxDiscountService")
public class MasterBoxDiscountService extends BaseService<MasterBoxDiscount, MasterBoxDiscountDTO, Integer> implements IMasterBoxDiscountService{
	
	@Autowired
	private IMasterBoxDiscountRepository masterBoxDiscountRepository;
	/**
	 * 
	 * @param typeT
	 * @param typeS
	 * @param baseRepository
	 */
	public MasterBoxDiscountService(Class<MasterBoxDiscount> typeT, Class<MasterBoxDiscountDTO> typeS,
			IBaseRepository<MasterBoxDiscount, Integer> baseRepository) {
		super(typeT, typeS, baseRepository);
	}

	private List<MasterBoxDiscount> getAllDummie(){
    	List<MasterBoxDiscount> lstBoxDiscounts = new ArrayList<MasterBoxDiscount>();
		MasterBoxDiscount BoxDiscount = new MasterBoxDiscount();
		BoxDiscount.setId(1);
		BoxDiscount.setDescription("PRIMER BOX DISCOUNT 1");
		lstBoxDiscounts.add(BoxDiscount);
		
		MasterBoxDiscount BoxDiscount2 = new MasterBoxDiscount();
		BoxDiscount2.setId(2);
		BoxDiscount2.setDescription("PRIMER BOX DISCOUNT 2");
		lstBoxDiscounts.add(BoxDiscount2);
		
		MasterBoxDiscount BoxDiscount3 = new MasterBoxDiscount();
		BoxDiscount3.setId(3);
		BoxDiscount3.setDescription("PRIMER BOX DISCOUNT 3");
		lstBoxDiscounts.add(BoxDiscount3);
		
		MasterBoxDiscount BoxDiscount4 = new MasterBoxDiscount();
		BoxDiscount4.setId(4);
		BoxDiscount4.setDescription("PRIMER BOX DISCOUNT 4");
		lstBoxDiscounts.add(BoxDiscount4);
		
		MasterBoxDiscount BoxDiscount5 = new MasterBoxDiscount();
		BoxDiscount5.setId(5);
		BoxDiscount5.setDescription("PRIMER BOX DISCOUNT 5");
		lstBoxDiscounts.add(BoxDiscount5);
		return lstBoxDiscounts;
	}
}
