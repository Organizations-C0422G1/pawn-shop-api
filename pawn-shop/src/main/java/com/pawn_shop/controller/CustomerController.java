package com.pawn_shop.controller;


import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pawnShop/")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/goCreateCustomer")
    public ResponseEntity<Void> createNewCustomer(@RequestBody Customer newCustomer){
        customerService.createCustomer(newCustomer);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
