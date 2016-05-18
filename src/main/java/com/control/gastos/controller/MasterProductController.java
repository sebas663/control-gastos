package com.control.gastos.controller;

import java.util.ArrayList;
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

import com.control.gastos.entities.MasterProduct;

@RestController
@EnableAutoConfiguration
public class MasterProductController {
	/**
	 * 
	 */
	private List<MasterProduct> lstProducts;
	private Long idCounter = 5L;
    /**
	 * 
	 */
	public MasterProductController() {
		super();
		lstProducts = getAllDummie();
	}
	@RequestMapping("/Product/getAll")
	ResponseEntity<List<MasterProduct>> getAll() {
		if(lstProducts.isEmpty()){
            return new ResponseEntity<List<MasterProduct>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MasterProduct>>(lstProducts, HttpStatus.OK);
    }
	
    @RequestMapping("/Product/create")
    ResponseEntity<Void> create(@RequestBody MasterProduct Product,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	Product.setId(idCounter);
    	lstProducts.add(Product);
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Product/add/{id}").buildAndExpand(Product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/Product/update/{id}")
    ResponseEntity<MasterProduct> update(@PathVariable("id") long id, @RequestBody MasterProduct Product) {
    	for(MasterProduct a:lstProducts){
    		if(a.getId().equals(id)){
    		a.setDescription(Product.getDescription());
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
        return new ResponseEntity<MasterProduct>(Product, HttpStatus.OK);
    }

	@RequestMapping("/Product/delete/{id}")
	ResponseEntity<MasterProduct> delete(@PathVariable("id") long id) {
		for (Iterator<MasterProduct> iterator = lstProducts.iterator(); iterator.hasNext();) {
			MasterProduct a = iterator.next();
			if (a.getId().equals(id)) {
				iterator.remove();
			}
		}
		// Product Product = userService.findById(id);
		// if (Product == null) {
		// System.out.println("Unable to delete. User with id " + id + " not
		// found");
		// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		// }

		// userService.deleteUserById(id);
		return new ResponseEntity<MasterProduct>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MasterProductController.class, args);
    }
    private List<MasterProduct> getAllDummie(){
    	List<MasterProduct> lstProducts = new ArrayList<MasterProduct>();
		MasterProduct Product = new MasterProduct();
		Product.setId(1L);
		Product.setDescription("PRODUCTO 1");
		lstProducts.add(Product);
		
		MasterProduct Product2 = new MasterProduct();
		Product2.setId(2L);
		Product2.setDescription("PRODUCTO 2");
		lstProducts.add(Product2);
		
		MasterProduct Product3 = new MasterProduct();
		Product3.setId(3L);
		Product3.setDescription("PRODUCTO 3");
		lstProducts.add(Product3);
		
		MasterProduct Product4 = new MasterProduct();
		Product4.setId(4L);
		Product4.setDescription("PRODUCTO 4");
		lstProducts.add(Product4);
		
		MasterProduct Product5 = new MasterProduct();
		Product5.setId(5L);
		Product5.setDescription("PRODUCTO 5");
		lstProducts.add(Product5);
		return lstProducts;
	}
}
