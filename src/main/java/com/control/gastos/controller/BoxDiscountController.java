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

import com.control.gastos.entities.BoxDiscount;

@RestController
@EnableAutoConfiguration
public class BoxDiscountController {
	/**
	 * 
	 */
	private List<BoxDiscount> lstBoxDiscounts;
	private Long idCounter = 0L;
    /**
	 * 
	 */
	public BoxDiscountController() {
		super();
		lstBoxDiscounts = getAllDummie();
	}
	@RequestMapping("/BoxDiscount/getAll")
	ResponseEntity<List<BoxDiscount>> getAll() {
		if(lstBoxDiscounts.isEmpty()){
            return new ResponseEntity<List<BoxDiscount>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BoxDiscount>>(lstBoxDiscounts, HttpStatus.OK);
    }
	
    @RequestMapping("/BoxDiscount/create")
    ResponseEntity<Void> create(@RequestBody BoxDiscount BoxDiscount,UriComponentsBuilder ucBuilder) {
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
    ResponseEntity<BoxDiscount> update(@PathVariable("id") long id, @RequestBody BoxDiscount BoxDiscount) {
    	for(BoxDiscount a:lstBoxDiscounts){
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
        return new ResponseEntity<BoxDiscount>(BoxDiscount, HttpStatus.OK);
    }

	@RequestMapping("/BoxDiscount/delete/{id}")
	ResponseEntity<BoxDiscount> delete(@PathVariable("id") long id) {
		for (Iterator<BoxDiscount> iterator = lstBoxDiscounts.iterator(); iterator.hasNext();) {
			BoxDiscount a = iterator.next();
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
		return new ResponseEntity<BoxDiscount>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BoxDiscountController.class, args);
    }
    private List<BoxDiscount> getAllDummie(){
    	List<BoxDiscount> lstBoxDiscounts = new ArrayList<BoxDiscount>();
		BoxDiscount BoxDiscount = new BoxDiscount();
		BoxDiscount.setId(1L);
		BoxDiscount.setDescription("PRIMER BOX DISCOUNT 1");
		lstBoxDiscounts.add(BoxDiscount);
		
		BoxDiscount BoxDiscount2 = new BoxDiscount();
		BoxDiscount2.setId(2L);
		BoxDiscount2.setDescription("PRIMER BOX DISCOUNT 2");
		lstBoxDiscounts.add(BoxDiscount2);
		
		BoxDiscount BoxDiscount3 = new BoxDiscount();
		BoxDiscount3.setId(3L);
		BoxDiscount3.setDescription("PRIMER BOX DISCOUNT 3");
		lstBoxDiscounts.add(BoxDiscount3);
		
		BoxDiscount BoxDiscount4 = new BoxDiscount();
		BoxDiscount4.setId(4L);
		BoxDiscount4.setDescription("PRIMER BOX DISCOUNT 4");
		lstBoxDiscounts.add(BoxDiscount4);
		
		BoxDiscount BoxDiscount5 = new BoxDiscount();
		BoxDiscount5.setId(5L);
		BoxDiscount5.setDescription("PRIMER BOX DISCOUNT 5");
		lstBoxDiscounts.add(BoxDiscount5);
		return lstBoxDiscounts;
	}
}
