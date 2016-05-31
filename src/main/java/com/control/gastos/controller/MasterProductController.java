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

import com.control.gastos.dtos.MasterProductDTO;
import com.control.gastos.services.interfaces.IMasterProductService;

@RestController
@EnableAutoConfiguration
public class MasterProductController {
	/**
	 * 
	 */
	@Autowired
	private IMasterProductService masterProductService;
    /**
	 * 
	 */
	public MasterProductController() {
		super();
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/Product/getAll")
	ResponseEntity<List<MasterProductDTO>> getAll() {
		List<MasterProductDTO> lstProducts = masterProductService.getAll();
		if(lstProducts.isEmpty()){
            return new ResponseEntity<List<MasterProductDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MasterProductDTO>>(lstProducts, HttpStatus.OK);
    }
	/**
	 * 
	 * @param Product
	 * @param ucBuilder
	 * @return
	 */
    @RequestMapping("/Product/create")
    ResponseEntity<Void> create(@RequestBody MasterProductDTO masterProductDTO,UriComponentsBuilder ucBuilder) {
    	if (masterProductDTO.getId() != null && masterProductService.isExist(masterProductDTO.getId())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    	masterProductService.saveOrUpdate(masterProductDTO);
    	HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Product/add/{id}").buildAndExpand(masterProductDTO.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    /**
     * 
     * @param id
     * @param masterProductDTO
     * @return
     */
    @RequestMapping("/Product/update/{id}")
    ResponseEntity<MasterProductDTO> update(@PathVariable("id") int id, @RequestBody MasterProductDTO masterProductDTO) {
    	MasterProductDTO current = masterProductService.findById(id);
        if (current==null) {
            return new ResponseEntity<MasterProductDTO>(HttpStatus.NOT_FOUND);
        }
        masterProductService.saveOrUpdate(masterProductDTO);
        return new ResponseEntity<MasterProductDTO>(masterProductDTO, HttpStatus.OK);
    }
    /**
     * 
     * @param id
     * @return
     */
	@RequestMapping("/Product/delete/{id}")
	ResponseEntity<MasterProductDTO> delete(@PathVariable("id") int id) {
		MasterProductDTO current = masterProductService.findById(id);
		if (current==null) {
            return new ResponseEntity<MasterProductDTO>(HttpStatus.NOT_FOUND);
        }
		masterProductService.delete(current);
		return new ResponseEntity<MasterProductDTO>(HttpStatus.NO_CONTENT);
	}
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MasterProductController.class, args);
    }
}
