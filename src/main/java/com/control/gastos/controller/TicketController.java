package com.control.gastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.control.gastos.dtos.TicketDTO;
import com.control.gastos.services.interfaces.ITicketService;

@RestController
@EnableAutoConfiguration
public class TicketController {
    /**
     * 
     */
	@Autowired
	private ITicketService ticketService;
    /**
	 * 
	 */
	public TicketController() {
		super();
	}
    /**
     * 
     * @param tiquet
     * @param ucBuilder
     * @return
     */
	@RequestMapping("/Ticket/save")
	ResponseEntity<Void> save(@RequestBody TicketDTO tiquet,UriComponentsBuilder ucBuilder) {
		if (tiquet.getId() != null && ticketService.isExist(tiquet.getId())) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		ticketService.saveOrUpdate(tiquet);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Ticket/add/{id}").buildAndExpand(tiquet.getId()).toUri());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TicketController.class, args);
    }
}
