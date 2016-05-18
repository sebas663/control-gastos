package com.control.gastos.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.control.gastos.entities.Ticket;

@RestController
@EnableAutoConfiguration
public class TicketController {

	private Long idCounter = 1L;
    /**
	 * 
	 */
	public TicketController() {
		super();
	}
//	@RequestMapping("/Ticket/getAll")
//	ResponseEntity<List<Ticket>> getAll() {
//		if(lstBuys.isEmpty()){
//            return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Ticket>>(lstBuys, HttpStatus.OK);
//    }
	
    @RequestMapping("/Ticket/add")
    ResponseEntity<Void> add(@RequestBody Ticket buy,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	
//    	if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
        
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Buy/add/{id}").buildAndExpand(buy.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
//    @RequestMapping("/Buy/update/{id}")
//    ResponseEntity<Ticket> update(@PathVariable("id") long id, @RequestBody Ticket buy) {
//    	for(Ticket a:lstBuys){
//    		if(a.getId().equals(id)){
//    		   a.setBuyDate(buy.getBuyDate());
//    		   a.setCompanyID(buy.getCompanyID());
//    		   a.setExternal_code(buy.getExternal_code());
//    		   a.setPrice(buy.getPrice());
//    		   a.setProductID(buy.getProductID());
//    		   a.setQuantity(buy.getQuantity());
//    		   a.setTotal(buy.getPrice() * buy.getQuantity());
//    		}
//    	}
    	  
//        User currentUser = userService.findById(id);
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        currentUser.setUsername(user.getUsername());
//        currentUser.setAddress(user.getAddress());
//        currentUser.setEmail(user.getEmail());
//        userService.updateUser(currentUser);
//        return new ResponseEntity<Ticket>(buy, HttpStatus.OK);
//    }

//	@RequestMapping("/Buy/delete/{id}")
//	ResponseEntity<Ticket> delete(@PathVariable("id") long id) {
//		for (Iterator<Ticket> iterator = lstBuys.iterator(); iterator.hasNext();) {
//			Ticket a = iterator.next();
//			if (a.getId().equals(id)) {
//				iterator.remove();
//			}
//		}
		// Buy buy = userService.findById(id);
		// if (buy == null) {
		// System.out.println("Unable to delete. User with id " + id + " not
		// found");
		// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		// }

		// userService.deleteUserById(id);
//		return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
//	}
//	 @RequestMapping("/Buy/save")
//	    ResponseEntity<Void> save(@RequestBody List<Ticket> lst,UriComponentsBuilder ucBuilder) {
		   // List<Buy> buys = requestWrapper.getBuys();
//		    lstBuys.clear();
//	    	if (userService.isUserExist(user)) {
//	            System.out.println("A User with name " + user.getUsername() + " already exist");
//	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//	        }
//	        userService.saveUser(user);
	        
//	    	HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(ucBuilder.path("/Buy/add/{id}").buildAndExpand(buy.getId()).toUri());
//	        return new ResponseEntity<Void>(HttpStatus.OK);
//	    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TicketController.class, args);
    }

}
