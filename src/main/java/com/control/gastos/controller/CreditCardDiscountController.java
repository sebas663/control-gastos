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

import com.control.gastos.entities.CreditCardDiscount;

@RestController
@EnableAutoConfiguration
public class CreditCardDiscountController {
	/**
	 * 
	 */
	private List<CreditCardDiscount> lstCreditCardDiscounts;
	private Long idCounter = 0L;
    /**
	 * 
	 */
	public CreditCardDiscountController() {
		super();
		lstCreditCardDiscounts = getAllDummie();
	}
	@RequestMapping("/CreditCardDiscount/getAll")
	ResponseEntity<List<CreditCardDiscount>> getAll() {
		if(lstCreditCardDiscounts.isEmpty()){
            return new ResponseEntity<List<CreditCardDiscount>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CreditCardDiscount>>(lstCreditCardDiscounts, HttpStatus.OK);
    }
	
    @RequestMapping("/CreditCardDiscount/create")
    ResponseEntity<Void> create(@RequestBody CreditCardDiscount CreditCardDiscount,UriComponentsBuilder ucBuilder) {
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
    ResponseEntity<CreditCardDiscount> update(@PathVariable("id") long id, @RequestBody CreditCardDiscount CreditCardDiscount) {
    	for(CreditCardDiscount a:lstCreditCardDiscounts){
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
        return new ResponseEntity<CreditCardDiscount>(CreditCardDiscount, HttpStatus.OK);
    }

	@RequestMapping("/CreditCardDiscount/delete/{id}")
	ResponseEntity<CreditCardDiscount> delete(@PathVariable("id") long id) {
		for (Iterator<CreditCardDiscount> iterator = lstCreditCardDiscounts.iterator(); iterator.hasNext();) {
			CreditCardDiscount a = iterator.next();
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
		return new ResponseEntity<CreditCardDiscount>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CreditCardDiscountController.class, args);
    }
    private List<CreditCardDiscount> getAllDummie(){
    	List<CreditCardDiscount> lstCreditCardDiscounts = new ArrayList<CreditCardDiscount>();
		CreditCardDiscount CreditCardDiscount = new CreditCardDiscount();
		CreditCardDiscount.setId(1L);
		CreditCardDiscount.setDescription("PRIMER CREDIT CARD 1");
		lstCreditCardDiscounts.add(CreditCardDiscount);
		
		CreditCardDiscount CreditCardDiscount2 = new CreditCardDiscount();
		CreditCardDiscount2.setId(2L);
		CreditCardDiscount2.setDescription("PRIMER CREDIT CARD 2");
		lstCreditCardDiscounts.add(CreditCardDiscount2);
		
		CreditCardDiscount CreditCardDiscount3 = new CreditCardDiscount();
		CreditCardDiscount3.setId(3L);
		CreditCardDiscount3.setDescription("PRIMER CREDIT CARD 3");
		lstCreditCardDiscounts.add(CreditCardDiscount3);
		
		CreditCardDiscount CreditCardDiscount4 = new CreditCardDiscount();
		CreditCardDiscount4.setId(4L);
		CreditCardDiscount4.setDescription("PRIMER CREDIT CARD 4");
		lstCreditCardDiscounts.add(CreditCardDiscount4);
		
		CreditCardDiscount CreditCardDiscount5 = new CreditCardDiscount();
		CreditCardDiscount5.setId(5L);
		CreditCardDiscount5.setDescription("PRIMER CREDIT CARD 5");
		lstCreditCardDiscounts.add(CreditCardDiscount5);
		return lstCreditCardDiscounts;
	}
}
