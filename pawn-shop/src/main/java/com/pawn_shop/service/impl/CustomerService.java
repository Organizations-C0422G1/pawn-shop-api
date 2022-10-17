package com.pawn_shop.service.impl;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.ICustomerRepository;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public <T> List<T> kiemAll(Class<T> tClass) {
        return iCustomerRepository.findAllCustomer(tClass);
    }

    @Override
    public <T> List<T> findByNameCustomer(String name,Class<T> tClass) {
        return iCustomerRepository.findByNameCustomer(name,tClass);
    }
}
