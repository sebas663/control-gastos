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

import com.control.gastos.entities.MasterBoxDiscount;
import com.control.gastos.services.interfaces.IMasterBoxDiscountService;

@RestController
@EnableAutoConfiguration
public class MasterBoxDiscountController {
	
	@Autowired
	private IMasterBoxDiscountService masterBoxDiscountService;
	/**
	 * 
	 */
	private List<MasterBoxDiscount> lstBoxDiscounts;
	private Integer idCounter = 0;
    /**
	 * 
	 */
	public MasterBoxDiscountController() {
		super();
		lstBoxDiscounts = getAllDummie();
	}
	@RequestMapping("/BoxDiscount/getAll")
	ResponseEntity<List<MasterBoxDiscount>> getAll() {
		if(lstBoxDiscounts.isEmpty()){
            return new ResponseEntity<List<MasterBoxDiscount>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MasterBoxDiscount>>(lstBoxDiscounts, HttpStatus.OK);
    }
	
    @RequestMapping("/BoxDiscount/create")
    ResponseEntity<Void> create(@RequestBody MasterBoxDiscount BoxDiscount,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	BoxDiscount.setId(idCounter);
    	lstBoxDiscounts.add(BoxDiscount);
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/BoxDiscount/add/{id}").buildAndExpand(BoxDiscount.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/BoxDiscount/update/{id}")
    ResponseEntity<MasterBoxDiscount> update(@PathVariable("id") long id, @RequestBody MasterBoxDiscount BoxDiscount) {
    	for(MasterBoxDiscount a:lstBoxDiscounts){
    		if(a.getId().equals(id)){
    		a.setDescription(BoxDiscount.getDescription());
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
        return new ResponseEntity<MasterBoxDiscount>(BoxDiscount, HttpStatus.OK);
    }

	@RequestMapping("/BoxDiscount/delete/{id}")
	ResponseEntity<MasterBoxDiscount> delete(@PathVariable("id") long id) {
		for (Iterator<MasterBoxDiscount> iterator = lstBoxDiscounts.iterator(); iterator.hasNext();) {
			MasterBoxDiscount a = iterator.next();
			if (a.getId().equals(id)) {
				iterator.remove();
			}
		}
		// BoxDiscount BoxDiscount = userService.findById(id);
		// if (BoxDiscount == null) {
		// System.out.println("Unable to delete. User with id " + id + " not
		// found");
		// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		// }

		// userService.deleteUserById(id);
		return new ResponseEntity<MasterBoxDiscount>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MasterBoxDiscountController.class, args);
    }
    private List<MasterBoxDiscount> getAllDummie(){
    	List<MasterBoxDiscount> lstBoxDiscounts = new ArrayList<MasterBoxDiscount>();
		MasterBoxDiscount BoxDiscount = new MasterBoxDiscount();
		BoxDiscount.setId(1);
		BoxDiscount.setDescription("PRIMER BOX DISCOUNT 1");
		lstBoxDiscounts.add(BoxDiscount);
		
		MasterBoxDiscount BoxDiscount2 = new MasterBoxDiscount();
		BoxDiscount2.setId(2);
		BoxDiscount2.setDescription("PRIMER BOX DISCOUNT 2");
		lstBoxDiscounts.add(BoxDiscount2);
		
		MasterBoxDiscount BoxDiscount3 = new MasterBoxDiscount();
		BoxDiscount3.setId(3);
		BoxDiscount3.setDescription("PRIMER BOX DISCOUNT 3");
		lstBoxDiscounts.add(BoxDiscount3);
		
		MasterBoxDiscount BoxDiscount4 = new MasterBoxDiscount();
		BoxDiscount4.setId(4);
		BoxDiscount4.setDescription("PRIMER BOX DISCOUNT 4");
		lstBoxDiscounts.add(BoxDiscount4);
		
		MasterBoxDiscount BoxDiscount5 = new MasterBoxDiscount();
		BoxDiscount5.setId(5);
		BoxDiscount5.setDescription("PRIMER BOX DISCOUNT 5");
		lstBoxDiscounts.add(BoxDiscount5);
		return lstBoxDiscounts;
	}
}
