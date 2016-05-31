package com.control.gastos.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.control.gastos.entities.MasterCreditCardDiscount;
import com.control.gastos.services.interfaces.IMasterCreditCardDiscountService;

@RestController
@EnableAutoConfiguration
public class MasterCreditCardDiscountController {
	
	@Autowired
	private IMasterCreditCardDiscountService masterCreditCardDiscountService;
	/**
	 * 
	 */
	private List<MasterCreditCardDiscount> lstCreditCardDiscounts;
	private Integer idCounter = 0;
    /**
	 * 
	 */
	public MasterCreditCardDiscountController() {
		super();
		lstCreditCardDiscounts = getAllDummie();
	}
	@RequestMapping("/CreditCardDiscount/getAll")
	ResponseEntity<List<MasterCreditCardDiscount>> getAll() {
		if(lstCreditCardDiscounts.isEmpty()){
            return new ResponseEntity<List<MasterCreditCardDiscount>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MasterCreditCardDiscount>>(lstCreditCardDiscounts, HttpStatus.OK);
    }
	
    @RequestMapping("/CreditCardDiscount/create")
    ResponseEntity<Void> create(@RequestBody MasterCreditCardDiscount CreditCardDiscount,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	CreditCardDiscount.setId(idCounter);
    	lstCreditCardDiscounts.add(CreditCardDiscount);
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/CreditCardDiscount/add/{id}").buildAndExpand(CreditCardDiscount.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/CreditCardDiscount/update/{id}")
    ResponseEntity<MasterCreditCardDiscount> update(@PathVariable("id") long id, @RequestBody MasterCreditCardDiscount CreditCardDiscount) {
    	for(MasterCreditCardDiscount a:lstCreditCardDiscounts){
    		if(a.getId().equals(id)){
    		a.setDescription(CreditCardDiscount.getDescription());
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
        return new ResponseEntity<MasterCreditCardDiscount>(CreditCardDiscount, HttpStatus.OK);
    }

	@RequestMapping("/CreditCardDiscount/delete/{id}")
	ResponseEntity<MasterCreditCardDiscount> delete(@PathVariable("id") long id) {
		for (Iterator<MasterCreditCardDiscount> iterator = lstCreditCardDiscounts.iterator(); iterator.hasNext();) {
			MasterCreditCardDiscount a = iterator.next();
			if (a.getId().equals(id)) {
				iterator.remove();
			}
		}
		// CreditCardDiscount CreditCardDiscount = userService.findById(id);
		// if (CreditCardDiscount == null) {
		// System.out.println("Unable to delete. User with id " + id + " not
		// found");
		// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		// }

		// userService.deleteUserById(id);
		return new ResponseEntity<MasterCreditCardDiscount>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MasterCreditCardDiscountController.class, args);
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
