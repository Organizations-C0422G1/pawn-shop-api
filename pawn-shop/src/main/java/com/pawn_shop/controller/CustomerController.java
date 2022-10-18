package com.pawn_shop.controller;


import com.pawn_shop.dto.CustomerDTO;
import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.service.impl.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pawnShop")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //    @PostMapping("/goCreateCustomer")
//    public ResponseEntity<Void> createNewCustomer(@RequestBody Customer newCustomer) {
//        customerService.createCustomer(newCustomer);
//        return new ResponseEntity<Void>(HttpStatus.CREATED);
//    }



//    @PatchMapping("/goUpdateCustomer")
//    public ResponseEntity<Void> updateOldCustomer(@RequestBody Customer oldCustomer) {
//        customerService.updateCustomer(oldCustomer.getId(), oldCustomer);
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }


    @PostMapping("/goCreateCustomer")
    public ResponseEntity<Void> createNewCustomer(@RequestBody @Valid CustomerDTO newCustomerDTO, BindingResult bindingResult) {
        newCustomerDTO.validate(newCustomerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(newCustomerDTO, customer);
        customerService.createCustomer(customer);
        customer.setCode("KH-");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PatchMapping("/goUpdateCustomer")
    public ResponseEntity<Void> updateOldCustomer(@RequestBody @Valid CustomerDTO updateCustomerDTO, BindingResult bindingResult) {
        updateCustomerDTO.validate(updateCustomerDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(updateCustomerDTO,customer);
        customerService.updateCustomer(customer.getId(),customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
