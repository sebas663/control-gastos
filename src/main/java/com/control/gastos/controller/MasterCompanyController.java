package com.control.gastos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.control.gastos.dtos.MasterCompanyDTO;
import com.control.gastos.services.interfaces.IMasterCompanyService;

@RestController
@EnableAutoConfiguration
public class MasterCompanyController {
	/**
	 * Service.
	 */
	@Autowired
	private IMasterCompanyService masterCompanyService;
	/**
	 * Constructor.
	 */
	public MasterCompanyController() {
		super();
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/Company/getAll")
	ResponseEntity<List<MasterCompanyDTO>> getAll() {
		List<MasterCompanyDTO> lstCompanys = masterCompanyService.getAll();
		if (lstCompanys.isEmpty()) {
			return new ResponseEntity<List<MasterCompanyDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MasterCompanyDTO>>(lstCompanys,HttpStatus.OK);
	}
	/**
	 * 
	 * @param Company
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping("/Company/create")
	ResponseEntity<Void> create(@RequestBody MasterCompanyDTO company,UriComponentsBuilder ucBuilder) {
		if (company.getId() !=null && masterCompanyService.isExist(company.getId())) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		masterCompanyService.saveOrUpdate(company);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Company/add/{id}").buildAndExpand(company.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	/**
	 * 
	 * @param id
	 * @param Company
	 * @return
	 */
	@RequestMapping("/Company/update/{id}")
	ResponseEntity<MasterCompanyDTO> update(@PathVariable("id") int id,@RequestBody MasterCompanyDTO company) {
		MasterCompanyDTO currentCompany = masterCompanyService.findById(id);
		if (currentCompany == null) {
			return new ResponseEntity<MasterCompanyDTO>(HttpStatus.NOT_FOUND);
		}
		masterCompanyService.saveOrUpdate(company);
		return new ResponseEntity<MasterCompanyDTO>(company, HttpStatus.OK);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/Company/delete/{id}")
	ResponseEntity<MasterCompanyDTO> delete(@PathVariable("id") int id) {
		MasterCompanyDTO currentCompany = masterCompanyService.findById(id);
		if (currentCompany == null) {
			return new ResponseEntity<MasterCompanyDTO>(HttpStatus.NOT_FOUND);
		}
		masterCompanyService.delete(currentCompany);
		return new ResponseEntity<MasterCompanyDTO>(HttpStatus.NO_CONTENT);
	}
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MasterCompanyController.class, args);
	}
}
