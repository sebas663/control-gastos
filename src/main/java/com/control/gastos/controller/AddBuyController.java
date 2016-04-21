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

import com.control.gastos.entities.Buy;

@RestController
@EnableAutoConfiguration
public class AddBuyController {
	/**
	 * 
	 */
	private List<Buy> lstBuys;
	private Long idCounter = 1L;
    /**
	 * 
	 */
	public AddBuyController() {
		super();
		lstBuys = new ArrayList<Buy>();
		Buy buy = new Buy();
		buy.setId(1L);
		buy.setCompanyID(1L);
		buy.setExternal_code("code");
		buy.setPrice(10D);
		buy.setQuantity(2);
		buy.setProductID(2L);
		buy.setTotal(20D);
		buy.setBuyDate(new Date());
		lstBuys.add(buy);
	}
	@RequestMapping("/addBuy/getAll")
	ResponseEntity<List<Buy>> getAll() {
		if(lstBuys.isEmpty()){
            return new ResponseEntity<List<Buy>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Buy>>(lstBuys, HttpStatus.OK);
    }
	
    @RequestMapping("/addBuy/add")
    ResponseEntity<Void> add(@RequestBody Buy buy,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	buy.setId(idCounter);
    	buy.setTotal(buy.getPrice() * buy.getQuantity());
    	lstBuys.add(buy);
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/addBuy/add/{id}").buildAndExpand(buy.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/addBuy/update/{id}")
    ResponseEntity<Buy> update(@PathVariable("id") long id, @RequestBody Buy buy) {
    	for(Buy a:lstBuys){
    		if(a.getId().equals(id)){
    		   a.setBuyDate(buy.getBuyDate());
    		   a.setCompanyID(buy.getCompanyID());
    		   a.setExternal_code(buy.getExternal_code());
    		   a.setPrice(buy.getPrice());
    		   a.setProductID(buy.getProductID());
    		   a.setQuantity(buy.getQuantity());
    		   a.setTotal(buy.getPrice() * buy.getQuantity());
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
        return new ResponseEntity<Buy>(buy, HttpStatus.OK);
    }

	@RequestMapping("/addBuy/delete/{id}")
	ResponseEntity<Buy> delete(@PathVariable("id") long id) {
		for (Iterator<Buy> iterator = lstBuys.iterator(); iterator.hasNext();) {
			Buy a = iterator.next();
			if (a.getId().equals(id)) {
				iterator.remove();
			}
		}
		// Buy buy = userService.findById(id);
		// if (buy == null) {
		// System.out.println("Unable to delete. User with id " + id + " not
		// found");
		// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		// }

		// userService.deleteUserById(id);
		return new ResponseEntity<Buy>(HttpStatus.NO_CONTENT);
	}
	 @RequestMapping("/addBuy/save")
	    ResponseEntity<Void> save(@RequestBody List<Buy> buys,UriComponentsBuilder ucBuilder) {
		    lstBuys.clear();
//	    	if (userService.isUserExist(user)) {
//	            System.out.println("A User with name " + user.getUsername() + " already exist");
//	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//	        }
//	        userService.saveUser(user);
	        
//	    	HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(ucBuilder.path("/addBuy/add/{id}").buildAndExpand(buy.getId()).toUri());
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AddBuyController.class, args);
    }

}
