package com.control.gastos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterProductDTO;
import com.control.gastos.entities.MasterProduct;
import com.control.gastos.jpa.repository.interfaces.IBaseRepository;
import com.control.gastos.jpa.repository.interfaces.IMasterProductRepository;
import com.control.gastos.services.interfaces.IMasterProductService;

@Service("masterProductService")
public class MasterProductService extends BaseService<MasterProduct, MasterProductDTO, Integer> implements IMasterProductService{
    /**
     * 
     */
	@Autowired 
	private IMasterProductRepository masterProductRepository;
	
	/**
	 * @param typeT
	 * @param typeS
	 * @param baseRepository
	 */
	public MasterProductService(Class<MasterProduct> typeT, Class<MasterProductDTO> typeS,
			IBaseRepository<MasterProduct, Integer> baseRepository) {
		super(typeT, typeS, baseRepository);
	}

	private List<MasterProduct> getAllDummie() {
		List<MasterProduct> lstProducts = new ArrayList<MasterProduct>();
		MasterProduct Product = new MasterProduct();
		Product.setId(1);
		Product.setDescription("PRODUCTO 1");
		lstProducts.add(Product);

		MasterProduct Product2 = new MasterProduct();
		Product2.setId(2);
		Product2.setDescription("PRODUCTO 2");
		lstProducts.add(Product2);

		MasterProduct Product3 = new MasterProduct();
		Product3.setId(3);
		Product3.setDescription("PRODUCTO 3");
		lstProducts.add(Product3);

		MasterProduct Product4 = new MasterProduct();
		Product4.setId(4);
		Product4.setDescription("PRODUCTO 4");
		lstProducts.add(Product4);

		MasterProduct Product5 = new MasterProduct();
		Product5.setId(5);
		Product5.setDescription("PRODUCTO 5");
		lstProducts.add(Product5);
		return lstProducts;
	}
}
