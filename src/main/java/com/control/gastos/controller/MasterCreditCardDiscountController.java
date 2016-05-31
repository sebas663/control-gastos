package com.control.gastos.controller;

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

import com.control.gastos.dtos.MasterCreditCardDiscountDTO;
import com.control.gastos.services.interfaces.IMasterCreditCardDiscountService;

@RestController
@EnableAutoConfiguration
public class MasterCreditCardDiscountController {
	/**
	 * 
	 */
	@Autowired
	private IMasterCreditCardDiscountService masterCreditCardDiscountService;
    /**
	 * 
	 */
	public MasterCreditCardDiscountController() {
		super();
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/CreditCardDiscount/getAll")
	ResponseEntity<List<MasterCreditCardDiscountDTO>> getAll() {
		List<MasterCreditCardDiscountDTO> lstCreditCardDiscounts = masterCreditCardDiscountService.getAll();
		if(lstCreditCardDiscounts.isEmpty()){
            return new ResponseEntity<List<MasterCreditCardDiscountDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MasterCreditCardDiscountDTO>>(lstCreditCardDiscounts, HttpStatus.OK);
    }
	/**
	 * 
	 * @param CreditCardDiscount
	 * @param ucBuilder
	 * @return
	 */
    @RequestMapping("/CreditCardDiscount/create")
    ResponseEntity<Void> create(@RequestBody MasterCreditCardDiscountDTO masterCreditCardDiscountDTO,UriComponentsBuilder ucBuilder) {
    	if (masterCreditCardDiscountDTO.getId() != null && masterCreditCardDiscountService.isExist(masterCreditCardDiscountDTO.getId())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    	masterCreditCardDiscountService.saveOrUpdate(masterCreditCardDiscountDTO);
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/CreditCardDiscount/add/{id}").buildAndExpand(masterCreditCardDiscountDTO.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    /**
     * 
     * @param id
     * @param CreditCardDiscount
     * @return
     */
    @RequestMapping("/CreditCardDiscount/update/{id}")
    ResponseEntity<MasterCreditCardDiscountDTO> update(@PathVariable("id") int id, @RequestBody MasterCreditCardDiscountDTO masterCreditCardDiscountDTO) {
    	MasterCreditCardDiscountDTO current = masterCreditCardDiscountService.findById(id);
        if (current==null) {
            return new ResponseEntity<MasterCreditCardDiscountDTO>(HttpStatus.NOT_FOUND);
        }
        masterCreditCardDiscountService.saveOrUpdate(masterCreditCardDiscountDTO);
        return new ResponseEntity<MasterCreditCardDiscountDTO>(masterCreditCardDiscountDTO, HttpStatus.OK);
    }
    /**
     * 
     * @param id
     * @return
     */
	@RequestMapping("/CreditCardDiscount/delete/{id}")
	ResponseEntity<MasterCreditCardDiscountDTO> delete(@PathVariable("id") int id) {
		MasterCreditCardDiscountDTO current = masterCreditCardDiscountService.findById(id);
		if (current==null) {
            return new ResponseEntity<MasterCreditCardDiscountDTO>(HttpStatus.NOT_FOUND);
        }
		masterCreditCardDiscountService.delete(current);
		return new ResponseEntity<MasterCreditCardDiscountDTO>(HttpStatus.NO_CONTENT);
	}
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MasterCreditCardDiscountController.class, args);
    }
}
