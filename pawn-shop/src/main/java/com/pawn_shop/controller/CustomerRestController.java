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

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping ("/customer/list")
    public ResponseEntity<List<Customer>> customerList () {
        List<Customer> customers = iCustomerService.findAllCus();
        if (customers.isEmpty()) {
    public ResponseEntity<Page<Customer>> customerList (@PageableDefault Pageable pageable) {
        Page<Customer> customers = iCustomerService.findAllCustomer(pageable);
        if (!customers.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @GetMapping("/findCustomerById")
    public ResponseEntity<Customer> findCustomerById (@RequestParam Long id) {
        Customer customer = iCustomerService.findCustomerById(id).orElse(null);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @GetMapping("/findCustomerByIdCard")
    public ResponseEntity<List<Customer>> findCustomerByIdCard(@RequestParam String idCard) {
        List<Customer> customerList = iCustomerService.findCustomerByIdCard(idCard);
        if (customerList==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping("/getCustomerToEdit")
    public ResponseEntity<?> getCustomerToEdit(){
        return new ResponseEntity<>(iCustomerService.findAllCustomer(), HttpStatus.OK);
        
    public ResponseEntity<Customer> findCustomerByIdCard(@RequestParam String idCard) {
        Customer customer = iCustomerService.findCustomerByIdCard(idCard).orElse(null);
        if (customer==null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
}
