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

import com.control.gastos.entities.MasterCompany;

@RestController
@EnableAutoConfiguration
public class MasterCompanyController {
	/**
	 * 
	 */
	private List<MasterCompany> lstCompanys;
	private Long idCounter = 0L;
    /**
	 * 
	 */
	public MasterCompanyController() {
		super();
		lstCompanys = getAllDummie();
	}
	@RequestMapping("/Company/getAll")
	ResponseEntity<List<MasterCompany>> getAll() {
		if(lstCompanys.isEmpty()){
            return new ResponseEntity<List<MasterCompany>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MasterCompany>>(lstCompanys, HttpStatus.OK);
    }
	
    @RequestMapping("/Company/create")
    ResponseEntity<Void> create(@RequestBody MasterCompany Company,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	Company.setId(idCounter);
    	lstCompanys.add(Company);
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Company/add/{id}").buildAndExpand(Company.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/Company/update/{id}")
    ResponseEntity<MasterCompany> update(@PathVariable("id") long id, @RequestBody MasterCompany Company) {
    	for(MasterCompany a:lstCompanys){
    		if(a.getId().equals(id)){
    		a.setDescription(Company.getDescription());
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
        return new ResponseEntity<MasterCompany>(Company, HttpStatus.OK);
    }

	@RequestMapping("/Company/delete/{id}")
	ResponseEntity<MasterCompany> delete(@PathVariable("id") long id) {
		for (Iterator<MasterCompany> iterator = lstCompanys.iterator(); iterator.hasNext();) {
			MasterCompany a = iterator.next();
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
		return new ResponseEntity<MasterCompany>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MasterCompanyController.class, args);
    }
    private List<MasterCompany> getAllDummie(){
    	List<MasterCompany> lstCompanys = new ArrayList<MasterCompany>();
		MasterCompany Company = new MasterCompany();
		Company.setId(1L);
		Company.setDescription("PRIMER EMPRESA 1");
		lstCompanys.add(Company);
		
		MasterCompany Company2 = new MasterCompany();
		Company2.setId(2L);
		Company2.setDescription("PRIMER EMPRESA 2");
		lstCompanys.add(Company2);
		
		MasterCompany Company3 = new MasterCompany();
		Company3.setId(3L);
		Company3.setDescription("PRIMER EMPRESA 3");
		lstCompanys.add(Company3);
		
		MasterCompany Company4 = new MasterCompany();
		Company4.setId(4L);
		Company4.setDescription("PRIMER EMPRESA 4");
		lstCompanys.add(Company4);
		
		MasterCompany Company5 = new MasterCompany();
		Company5.setId(5L);
		Company5.setDescription("PRIMER EMPRESA 5");
		lstCompanys.add(Company5);
		return lstCompanys;
	}
}
