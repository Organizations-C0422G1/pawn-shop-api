package com.pawn_shop.service.impl;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.ICustomerRepository;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return iCustomerRepository.findAllCustomer(pageable);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return iCustomerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> findCustomerByIdCard(String idCard) {
    public Optional<Customer> findCustomerByIdCard(String idCard) {
        return iCustomerRepository.findCustomerByIdCard(idCard);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return iCustomerRepository.findAllCustomer();
    }

    @Override
    public List<Customer> findAllCus() {
        return iCustomerRepository.findAllCus();
    public Customer createQuickCustomer(Customer customer) {
        return this.iCustomerRepository.save(customer);
    }
}
