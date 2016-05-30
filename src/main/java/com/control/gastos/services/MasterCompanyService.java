package com.control.gastos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterCompanyDTO;
import com.control.gastos.entities.MasterCompany;
import com.control.gastos.interfaces.services.IMasterCompanyService;
import com.control.gastos.jpa.repository.interfaces.IMasterCompanyRepository;

@Service("masterCompanyService")
public class MasterCompanyService extends BaseService implements IMasterCompanyService{
	@Autowired 
	private IMasterCompanyRepository masterCompanyRepository;
	
	private List<MasterCompany> getAllDummie(){
    	List<MasterCompany> lstCompanys = new ArrayList<MasterCompany>();
		MasterCompany Company = new MasterCompany();
		Company.setId(1);
		Company.setDescription("PRIMER EMPRESA 1");
		lstCompanys.add(Company);
		
		MasterCompany Company2 = new MasterCompany();
		Company2.setId(2);
		Company2.setDescription("PRIMER EMPRESA 2");
		lstCompanys.add(Company2);
		
		MasterCompany Company3 = new MasterCompany();
		Company3.setId(3);
		Company3.setDescription("PRIMER EMPRESA 3");
		lstCompanys.add(Company3);
		
		MasterCompany Company4 = new MasterCompany();
		Company4.setId(4);
		Company4.setDescription("PRIMER EMPRESA 4");
		lstCompanys.add(Company4);
		
		MasterCompany Company5 = new MasterCompany();
		Company5.setId(5);
		Company5.setDescription("PRIMER EMPRESA 5");
		lstCompanys.add(Company5);
		return lstCompanys;
	}

	@Override
	public List<MasterCompanyDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(MasterCompanyDTO company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(MasterCompanyDTO company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MasterCompanyDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MasterCompanyDTO currentCompany, MasterCompanyDTO company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MasterCompanyDTO currentCompany) {
		// TODO Auto-generated method stub
		
	}
}
