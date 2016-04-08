package com.control.gastos.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class IndexController {
	
	@RequestMapping("/home")
	String home() {
		return "index";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(IndexController.class, args);
	}
}
