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

import com.control.gastos.entities.Product;

@RestController
@EnableAutoConfiguration
public class ProductController {
	/**
	 * 
	 */
	private List<Product> lstProducts;
	private Long idCounter = 0L;
    /**
	 * 
	 */
	public ProductController() {
		super();
		lstProducts = getAllDummie();
	}
	@RequestMapping("/product/getAll")
	ResponseEntity<List<Product>> getAll() {
		if(lstProducts.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Product>>(lstProducts, HttpStatus.OK);
    }
	
    @RequestMapping("/product/create")
    ResponseEntity<Void> create(@RequestBody Product product,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	product.setId(idCounter);
    	lstProducts.add(product);
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/add/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/product/update/{id}")
    ResponseEntity<Product> update(@PathVariable("id") long id, @RequestBody Product product) {
    	for(Product a:lstProducts){
    		if(a.getId().equals(id)){
    		a.setDescription(product.getDescription());
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
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

	@RequestMapping("/product/delete/{id}")
	ResponseEntity<Product> delete(@PathVariable("id") long id) {
		for (Iterator<Product> iterator = lstProducts.iterator(); iterator.hasNext();) {
			Product a = iterator.next();
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
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProductController.class, args);
    }
    private List<Product> getAllDummie(){
    	List<Product> lstProducts = new ArrayList<Product>();
		Product Product = new Product();
		Product.setId(1L);
		Product.setDescription("PRODUCTO 1");
		lstProducts.add(Product);
		
		Product Product2 = new Product();
		Product2.setId(2L);
		Product2.setDescription("PRODUCTO 2");
		lstProducts.add(Product2);
		
		Product Product3 = new Product();
		Product3.setId(3L);
		Product3.setDescription("PRODUCTO 3");
		lstProducts.add(Product3);
		
		Product Product4 = new Product();
		Product4.setId(4L);
		Product4.setDescription("PRODUCTO 4");
		lstProducts.add(Product4);
		
		Product Product5 = new Product();
		Product5.setId(5L);
		Product5.setDescription("PRODUCTO 5");
		lstProducts.add(Product5);
		return lstProducts;
	}
}
