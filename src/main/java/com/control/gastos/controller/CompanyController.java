package com.control.gastos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import com.control.gastos.entities.Company;

@RestController
@EnableAutoConfiguration
public class CompanyController {
	/**
	 * 
	 */
	private List<Company> lstCompanys;
	private Long idCounter = 0L;
    /**
	 * 
	 */
	public CompanyController() {
		super();
		lstCompanys = getAllDummie();
	}
	@RequestMapping("/company/getAll")
	ResponseEntity<List<Company>> getAll() {
		if(lstCompanys.isEmpty()){
            return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Company>>(lstCompanys, HttpStatus.OK);
    }
	
    @RequestMapping("/company/create")
    ResponseEntity<Void> create(@RequestBody Company company,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	company.setId(idCounter);
    	lstCompanys.add(company);
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/company/add/{id}").buildAndExpand(company.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/company/update/{id}")
    ResponseEntity<Company> update(@PathVariable("id") long id, @RequestBody Company company) {
    	for(Company a:lstCompanys){
    		if(a.getId().equals(id)){
    		a.setDescription(company.getDescription());
    		}
    	}
    	  
//        User currentUser = userService.findById(id);
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        currentUser.setUsername(user.getUsername());
//        currentUser.setAddress(user.getAddress());
//        currentUser.setEmail(user.getEmail());
//        userService.updateUser(currentUser);
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }

	@RequestMapping("/company/delete/{id}")
	ResponseEntity<Company> delete(@PathVariable("id") long id) {
		for (Iterator<Company> iterator = lstCompanys.iterator(); iterator.hasNext();) {
			Company a = iterator.next();
			if (a.getId().equals(id)) {
				iterator.remove();
			}
		}
		// Company Company = userService.findById(id);
		// if (Company == null) {
		// System.out.println("Unable to delete. User with id " + id + " not
		// found");
		// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		// }

		// userService.deleteUserById(id);
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CompanyController.class, args);
    }
    private List<Company> getAllDummie(){
    	List<Company> lstCompanys = new ArrayList<Company>();
		Company company = new Company();
		company.setId(1L);
		company.setDescription("PRIMER EMPRESA 1");
		lstCompanys.add(company);
		
		Company company2 = new Company();
		company2.setId(2L);
		company2.setDescription("PRIMER EMPRESA 2");
		lstCompanys.add(company2);
		
		Company company3 = new Company();
		company3.setId(3L);
		company3.setDescription("PRIMER EMPRESA 3");
		lstCompanys.add(company3);
		
		Company company4 = new Company();
		company4.setId(4L);
		company4.setDescription("PRIMER EMPRESA 4");
		lstCompanys.add(company4);
		
		Company company5 = new Company();
		company5.setId(5L);
		company5.setDescription("PRIMER EMPRESA 5");
		lstCompanys.add(company5);
		return lstCompanys;
	}
}
