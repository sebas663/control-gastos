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
	private Long idCounter = 0L;
    /**
	 * 
	 */
	public AddBuyController() {
		super();
		lstBuys = new ArrayList<Buy>();
		Buy buy = new Buy();
		buy.setId(0L);
		buy.setCompanyID(0L);
		buy.setExternal_code("code");
		buy.setPrice(10D);
		buy.setQuantity(2);
		buy.setProductID(0L);
		buy.setTotal(20D);
		buy.setBuyDate(new Date());
		lstBuys.add(buy);
	}
	@RequestMapping("/addBuy/getAll")
	ResponseEntity<List<Buy>> getAll() {
        return new ResponseEntity<List<Buy>>(lstBuys, HttpStatus.OK);
    }
	
    @RequestMapping("/addBuy/add")
    ResponseEntity<Void> add(@RequestBody Buy buy,UriComponentsBuilder ucBuilder) {
    	idCounter++;
    	buy.setId(idCounter);
    	lstBuys.add(buy);
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/addBuy/add/{id}").buildAndExpand(buy.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @RequestMapping("/addBuy/update/{id}")
    void update(@PathVariable("id") long id, @RequestBody Buy buy) {
    	for(Buy a:lstBuys){
    		if(a.getId().equals(id)){
    		   a.setBuyDate(buy.getBuyDate());
    		   a.setCompanyID(buy.getCompanyID());
    		   a.setExternal_code(buy.getExternal_code());
    		   a.setPrice(buy.getPrice());
    		   a.setProductID(buy.getProductID());
    		   a.setQuantity(buy.getQuantity());
    		}
    	}
    }
    @RequestMapping("/addBuy/delete/{id}")
    void delete(@PathVariable("id") long id) {
    	for (Iterator<Buy> iterator = lstBuys.iterator(); iterator.hasNext(); ) {
    		Buy a = iterator.next();
    	    if(a.getId().equals(id)){
    	    	iterator.remove();
    		}
    	}
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AddBuyController.class, args);
    }

}
