package com.control.gastos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    List<Buy> getAll() {
        return lstBuys;
    }
	
    @RequestMapping("/addBuy/add")
    void add(@RequestBody Buy buy) {
    	idCounter++;
    	buy.setId(idCounter);
    	lstBuys.add(buy);
    	
//        return "Hello World add !";
    }
    @RequestMapping("/addBuy/update")
    String update() {
        return "Hello World! update";
    }
    @RequestMapping("/addBuy/delete")
    String delete() {
        return "Hello World! delete";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AddBuyController.class, args);
    }

}
