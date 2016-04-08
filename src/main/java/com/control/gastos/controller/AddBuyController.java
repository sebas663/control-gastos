package com.control.gastos.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class AddBuyController {

    @RequestMapping("/addBuy/getAll")
    String getAll() {
        return "Hello World getAll!";
    }
    @RequestMapping("/addBuy/add")
    String add() {
        return "Hello World add !";
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
