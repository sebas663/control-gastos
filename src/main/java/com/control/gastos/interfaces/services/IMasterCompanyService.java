package com.control.gastos.interfaces.services;

import java.util.List;

import com.control.gastos.dtos.MasterCompanyDTO;

public interface IMasterCompanyService {

	List<MasterCompanyDTO> getAll();

	boolean isExist(MasterCompanyDTO company);

	void save(MasterCompanyDTO company);

	MasterCompanyDTO findById(int id);

	void update(MasterCompanyDTO currentCompany, MasterCompanyDTO company);

	void delete(MasterCompanyDTO currentCompany);

}
