package com.pawn_shop.service.impl;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.ICustomerRepository;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer createQuickCustomer(Customer customer) {
        return this.iCustomerRepository.save(customer);
    }
}
