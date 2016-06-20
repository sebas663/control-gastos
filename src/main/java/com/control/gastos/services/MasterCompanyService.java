package com.control.gastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.gastos.dtos.MasterCompanyDTO;
import com.control.gastos.entities.MasterCompany;
import com.control.gastos.jpa.repository.interfaces.IMasterCompanyRepository;
import com.control.gastos.services.interfaces.IMasterCompanyService;

@Service("masterCompanyService")
public class MasterCompanyService extends CRUDService<MasterCompany, MasterCompanyDTO, Integer> implements IMasterCompanyService{
    /**
     * 
     */
	@Autowired 
	private static IMasterCompanyRepository masterCompanyRepository;
}
