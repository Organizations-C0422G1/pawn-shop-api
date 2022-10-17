package com.pawn_shop.controller;

import com.pawn_shop.dto.CustomerDto;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "")
    public ResponseEntity<Page<CustomerDto>> getAllCustomer(@RequestParam Optional<String> name,
                                                            @PageableDefault(size = 3) Pageable pageable) {
        String name1 = name.orElse("");
        Page<CustomerDto> customerPage = iCustomerService.findAllCustomer("%" + name1 + "%", pageable);
        if (!customerPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage,HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Integer id) {
        this.iCustomerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
