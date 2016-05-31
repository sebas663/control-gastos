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

import com.control.gastos.dtos.MasterBoxDiscountDTO;
import com.control.gastos.services.interfaces.IMasterBoxDiscountService;

@RestController
@EnableAutoConfiguration
public class MasterBoxDiscountController {
	/**
	 * 
	 */
	@Autowired
	private IMasterBoxDiscountService masterBoxDiscountService;
    /**
	 * 
	 */
	public MasterBoxDiscountController() {
		super();
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/BoxDiscount/getAll")
	ResponseEntity<List<MasterBoxDiscountDTO>> getAll() {
		List<MasterBoxDiscountDTO> lstBoxDiscounts = masterBoxDiscountService.getAll();
		if(lstBoxDiscounts.isEmpty()){
            return new ResponseEntity<List<MasterBoxDiscountDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MasterBoxDiscountDTO>>(lstBoxDiscounts, HttpStatus.OK);
    }
	/**
	 * 
	 * @param masterBoxDiscountDTO
	 * @param ucBuilder
	 * @return
	 */
    @RequestMapping("/BoxDiscount/create")
    ResponseEntity<Void> create(@RequestBody MasterBoxDiscountDTO masterBoxDiscountDTO,UriComponentsBuilder ucBuilder) {
    	if (masterBoxDiscountDTO.getId() != null && masterBoxDiscountService.isExist(masterBoxDiscountDTO.getId())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    	masterBoxDiscountService.saveOrUpdate(masterBoxDiscountDTO);
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/BoxDiscount/add/{id}").buildAndExpand(masterBoxDiscountDTO.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    /**
     * 
     * @param id
     * @param BoxDiscount
     * @return
     */
    @RequestMapping("/BoxDiscount/update/{id}")
    ResponseEntity<MasterBoxDiscountDTO> update(@PathVariable("id") int id, @RequestBody MasterBoxDiscountDTO masterBoxDiscountDTO) {
    	MasterBoxDiscountDTO current = masterBoxDiscountService.findById(id);
        if (current==null) {
            return new ResponseEntity<MasterBoxDiscountDTO>(HttpStatus.NOT_FOUND);
        }
        masterBoxDiscountService.saveOrUpdate(masterBoxDiscountDTO);
        return new ResponseEntity<MasterBoxDiscountDTO>(masterBoxDiscountDTO, HttpStatus.OK);
    }
    /**
     * 
     * @param id
     * @return
     */
	@RequestMapping("/BoxDiscount/delete/{id}")
	ResponseEntity<MasterBoxDiscountDTO> delete(@PathVariable("id") int id) {
		MasterBoxDiscountDTO current = masterBoxDiscountService.findById(id);
		if (current==null) {
            return new ResponseEntity<MasterBoxDiscountDTO>(HttpStatus.NOT_FOUND);
        }
		masterBoxDiscountService.delete(current);
		return new ResponseEntity<MasterBoxDiscountDTO>(HttpStatus.NO_CONTENT);
	}
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MasterBoxDiscountController.class, args);
    }
}
