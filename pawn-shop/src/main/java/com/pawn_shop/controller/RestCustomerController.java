package com.pawn_shop.controller;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class RestCustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping ("/customer/list")
    public ResponseEntity<Page<Customer>> customerList (@PageableDefault Pageable pageable) {
        Page<Customer> customers = iCustomerService.findAllCustomer(pageable);
        if (!customers.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @GetMapping("/findCustomerById")
    public ResponseEntity<Customer> findCustomerById (@RequestParam int id) {
        Customer customer = iCustomerService.findCustomerById(id).orElse(null);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @GetMapping("/findCustomerByIdCard")
    public ResponseEntity<Customer> findCustomerByIdCard(@RequestParam String idCard) {
        Customer customer = iCustomerService.findCustomerByIdCard(idCard).orElse(null);
        if (customer==null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
}
