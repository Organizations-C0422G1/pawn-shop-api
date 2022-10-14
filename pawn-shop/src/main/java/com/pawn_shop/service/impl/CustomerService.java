package com.pawn_shop.service.impl;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.ICustomerRepository;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public void createCustomer(Customer newCustomer) {
        iCustomerRepository.createCustomer(newCustomer.getCode(), newCustomer.getDateOfBirth(), newCustomer.getEmail(),
                newCustomer.getGender(), newCustomer.getIdCard(), newCustomer.getImgUrl(), newCustomer.getName(),
                newCustomer.getPhoneNumber(), newCustomer.getStatus(), newCustomer.getAddress());
    }
}
